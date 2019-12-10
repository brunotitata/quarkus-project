package org.acme.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.acme.http.MunicipioHttpClient;
import org.acme.model.MunicipioEntity;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService {

    @RestClient
    private MunicipioHttpClient municipioHttpClient;
    private OpenWeatherService openWeatherService;

    public MunicipioService(OpenWeatherService openWeatherService) {
        this.openWeatherService = openWeatherService;
    }

    public void salvarMunicipios() {
        municipioHttpClient.buscarTodosMunicipios()
                .forEach(municipio -> MunicipioEntity.persist(new MunicipioEntity(municipio.getNome(),
                        municipio.getMicrorregiao().getMesorregiao().getUF().getSigla(),
                        Climate.convertKelvinToCelsius(
                                openWeatherService.getCityByName(municipio.getNome()).getMain().getTemp()),
                        LocalDateTime.now())));
    }

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

}