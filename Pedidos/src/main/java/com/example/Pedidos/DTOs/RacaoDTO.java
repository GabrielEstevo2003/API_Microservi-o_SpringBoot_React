package com.example.Pedidos.DTOs;

public class RacaoDTO {
    private Long id;
    private String nome;
    private String tipo;
    private String sabor;
    private Double preco;
    private Long disponibilidade;
    private Double peso;

    public RacaoDTO(Long id, String nome, String tipo, String sabor,
                    Double preco, Long disponibilidade, Double peso) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.sabor = sabor;
        this.preco = preco;
        this.disponibilidade = disponibilidade;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Long disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    // outros campos...
}