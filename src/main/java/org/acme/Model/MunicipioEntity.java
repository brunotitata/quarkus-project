package org.acme.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "Municipios")
public class MunicipioEntity extends PanacheEntity {

    @NotNull
    private UUID uuid;
    private String nome;
    private String sigla;
    private Integer temperatura;
    @JsonbProperty("hora_atual")
    private LocalDateTime horaAtual;

    public MunicipioEntity(String nome, String sigla, Integer temperatura, LocalDateTime horaAtual) {
	this.nome = nome;
	this.sigla = sigla;
	this.temperatura = temperatura;
	this.horaAtual = horaAtual;
    }

    @PrePersist
    public void prePersist() {
	uuid = UUID.randomUUID();
    }

    @PreUpdate
    public void preUpdate() {
	horaAtual = LocalDateTime.now();
    }

    public MunicipioEntity() {
    }

    public UUID getUuid() {
	return uuid;
    }

    public void setUuid(UUID uuid) {
	this.uuid = uuid;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getSigla() {
	return sigla;
    }

    public void setSigla(String sigla) {
	this.sigla = sigla;
    }

    public Integer getTemperatura() {
	return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
	this.temperatura = temperatura;
    }

    @Override
    public String toString() {
	return "MunicipioEntity [id=" + id + ", uuid=" + uuid + ", nome=" + nome + ", sigla=" + sigla + ", temperatura="
		+ temperatura + ", horaAtual=" + horaAtual + "]";
    }

    public LocalDateTime getHoraAtual() {
	return horaAtual;
    }

    public void setHoraAtual(LocalDateTime horaAtual) {
	this.horaAtual = horaAtual;
    }

    public static class MunicipioData {

	@NotEmpty(message = "Nome do municipio não pode ser vazio ou nulo.")
	private String nome;
	@NotEmpty(message = "Sigla não pode ser nulo ou vazio.")
	private String sigla;
	private Integer temperatura;
	private LocalDateTime horaAtual;

	public MunicipioData(String nome, String sigla, Integer temperatura, LocalDateTime horaAtual) {
	    this.nome = nome;
	    this.sigla = sigla;
	    this.temperatura = temperatura;
	    this.horaAtual = horaAtual;
	}

	public MunicipioData() {
	}

	public String getNome() {
	    return nome;
	}

	public void setNome(String nome) {
	    this.nome = nome;
	}

	public String getSigla() {
	    return sigla;
	}

	public void setSigla(String sigla) {
	    this.sigla = sigla;
	}

	public Integer getTemperatura() {
	    return temperatura;
	}

	public void setTemperatura(Integer temperatura) {
	    this.temperatura = temperatura;
	}

	public LocalDateTime getHoraAtual() {
	    return horaAtual;
	}

	public void setHoraAtual(LocalDateTime horaAtual) {
	    this.horaAtual = horaAtual;
	}

	@Override
	public String toString() {
	    return "MunicipioData [nome=" + nome + ", sigla=" + sigla + ", temperatura=" + temperatura + ", horaAtual="
		    + horaAtual + "]";
	}

    }

}