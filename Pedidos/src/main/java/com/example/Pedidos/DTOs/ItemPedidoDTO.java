package com.example.Pedidos.DTOs;

public class ItemPedidoDTO {
    private Long idRacao;
    private Integer quantidade;

    public Long getIdRacao() {
        return idRacao;
    }

    public void setIdRacao(Long idRacao) {
        this.idRacao = idRacao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
