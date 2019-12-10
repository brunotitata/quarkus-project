package org.acme.model;

import javax.json.bind.annotation.JsonbProperty;

public class CidadeResource {

    private String id;
    private Microrregiao microrregiao;
    private String nome;

    public CidadeResource(String id, Microrregiao microrregiao, String nome) {
        this.id = id;
        this.microrregiao = microrregiao;
        this.nome = nome;
    }

    public CidadeResource() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Microrregiao getMicrorregiao() {
        return microrregiao;
    }

    public void setMicrorregiao(Microrregiao microrregiao) {
        this.microrregiao = microrregiao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static class Microrregiao {

        private String id;
        private Mesorregiao mesorregiao;

        private String nome;

        public Microrregiao(String id, Mesorregiao mesorregiao, String nome) {
            this.id = id;
            this.mesorregiao = mesorregiao;
            this.nome = nome;
        }

        @SuppressWarnings("unused")
        public Microrregiao() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Mesorregiao getMesorregiao() {
            return mesorregiao;
        }

        public void setMesorregiao(Mesorregiao mesorregiao) {
            this.mesorregiao = mesorregiao;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

    }

    public static class Mesorregiao {

        @JsonbProperty("UF")
        private UF uF;

        @JsonbProperty("id")
        private String id;

        @JsonbProperty("nome")
        private String nome;

        public Mesorregiao(UF uF, String id, String nome) {
            this.uF = uF;
            this.id = id;
            this.nome = nome;
        }

        public Mesorregiao() {
        }

        @JsonbProperty("UF")
        public UF getUF() {
            return uF;
        }

        @JsonbProperty("UF")
        public void setUF(UF uF) {
            this.uF = uF;
        }

        @JsonbProperty("id")
        public String getId() {
            return id;
        }

        @JsonbProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        @JsonbProperty("nome")
        public String getNome() {
            return nome;
        }

        @JsonbProperty("nome")
        public void setNome(String nome) {
            this.nome = nome;
        }

        @Override
        public String toString() {
            return "Mesorregiao [uF=" + uF + ", id=" + id + ", nome=" + nome + "]";
        }

    }

    public static class UF {

        private String id;
        private String nome;
        private Regiao regiao;
        private String sigla;

        public UF(String id, String nome, Regiao regiao, String sigla) {
            this.id = id;
            this.nome = nome;
            this.regiao = regiao;
            this.sigla = sigla;
        }

        @SuppressWarnings("unused")
        public UF() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Regiao getRegiao() {
            return regiao;
        }

        public void setRegiao(Regiao regiao) {
            this.regiao = regiao;
        }

        public String getSigla() {
            return sigla;
        }

        public void setSigla(String sigla) {
            this.sigla = sigla;
        }

        @Override
        public String toString() {
            return "UF [id=" + id + ", nome=" + nome + ", regiao=" + regiao + ", sigla=" + sigla + "]";
        }

    }

    public static class Regiao {

        private String id;
        private String nome;
        private String sigla;

        public Regiao(String id, String nome, String sigla) {
            this.id = id;
            this.nome = nome;
            this.sigla = sigla;
        }

        public Regiao() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        @Override
        public String toString() {
            return "Regiao [id=" + id + ", nome=" + nome + ", sigla=" + sigla + "]";
        }

    }

}