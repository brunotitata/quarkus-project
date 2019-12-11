package org.acme.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.acme.http.MunicipioHttpClient;
import org.acme.model.MunicipioEntity;
import org.acme.model.MunicipioEntity.MunicipioData;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class MunicipioService {

    @RestClient
    MunicipioHttpClient municipioHttpClient;
    private OpenWeatherService openWeatherService;

    public MunicipioService(OpenWeatherService openWeatherService) {
	this.openWeatherService = openWeatherService;
    }

    @Transactional
    public void salvarMunicipios() {
	municipioHttpClient.buscarTodosMunicipios()
		.forEach(municipio -> MunicipioEntity.persist(new MunicipioEntity(municipio.getNome(),
			municipio.getMicrorregiao().getMesorregiao().getUF().getSigla(),
			Climate.convertKelvinToCelsius(
				openWeatherService.getCityByName(municipio.getNome()).getMain().getTemp()),
			LocalDateTime.now())));
    }

    @Transactional
    public List<MunicipioEntity> listarTodosMunicipiosSalvo() {
	return MunicipioEntity.findAll().list();
    }

    @Transactional
    public void salvarMunicipioDoEstadoDeSP() {
	municipioHttpClient.buscarTodosMunicipios().stream()
		.filter(uf -> "DF".equals(uf.getMicrorregiao().getMesorregiao().getUF().getSigla()))
		.forEach(municipio -> MunicipioEntity.persist(new MunicipioEntity(municipio.getNome(),
			municipio.getMicrorregiao().getMesorregiao().getUF().getSigla(),
			Climate.convertKelvinToCelsius(
				openWeatherService.getCityByName(municipio.getNome()).getMain().getTemp()),
			LocalDateTime.now())));
    }

    @Transactional
    public MunicipioEntity cadastrarMunicipio(MunicipioData municipioData) {

	MunicipioEntity municipio = new MunicipioEntity();
	municipio.setHoraAtual(municipioData.getHoraAtual());
	municipio.setNome(municipioData.getNome());
	municipio.setSigla(municipioData.getSigla());
	municipio.setTemperatura(municipioData.getTemperatura());
	municipio.persist();

	return municipio;
    }

    @Transactional
    public MunicipioEntity buscarMunicipioPorUUID(UUID uuid) {
	return MunicipioEntity.find("uuid", uuid).firstResult();
    }

    @Transactional
    public void deletarMunicipioPorUUID(UUID uuid) {
	MunicipioEntity.delete("uuid", uuid);
    }

}