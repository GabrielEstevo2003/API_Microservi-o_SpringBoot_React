package com.example.Pedidos.DTOs;

import java.util.List;

public class PedidoCriacaoDTO {
    private Long idUsuario;
    private Double precoTotal;
    private List<ItemPedidoDTO> itens;


    @Override
    public String toString() {
        return "PedidoCriacaoDTO{" +
                "idUsuario=" + idUsuario +
                ", precoTotal=" + precoTotal +
                ", itens=" + itens +
                '}';
    }


    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }



    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public List<ItemPedidoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }
}
