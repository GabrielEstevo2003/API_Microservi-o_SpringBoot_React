package com.example.Pedidos.DTOs;

public class EnderecoDTO {
    private Long id;
    private String cep;
    private String localidade;
    private String logradouro;
    private String uf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public EnderecoDTO(Long id, String cep, String localidade, String logradouro, String uf) {
        this.id = id;
        this.cep = cep;
        this.localidade = localidade;
        this.logradouro = logradouro;
        this.uf = uf;
    }
}
