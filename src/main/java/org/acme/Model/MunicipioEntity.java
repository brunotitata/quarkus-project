package org.acme.model;

import java.time.LocalDateTime;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "Municipios")
public class MunicipioEntity extends PanacheEntity {

    @Id
    @GeneratedValue
    private Long id;
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

    public MunicipioEntity() {
    }

    public Long getId() {
        return id;
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
        return "MunicipioEntity [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", temperatura=" + temperatura
                + "]";
    }

    public LocalDateTime getHoraAtual() {
        return horaAtual;
    }

    public void setHoraAtual(LocalDateTime horaAtual) {
        this.horaAtual = horaAtual;
    }

}