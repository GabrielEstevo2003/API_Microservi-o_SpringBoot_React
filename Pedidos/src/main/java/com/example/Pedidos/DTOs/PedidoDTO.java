package com.example.Pedidos.DTOs;

import com.example.Pedidos.Models.Pedido;

import java.util.Date;
import java.util.List;

public class PedidoDTO {
    private Long id;
    private Date dtCompra;
    private Double precoTotal;
    private UsuarioDTO usuario;
    private List<RacaoDTO> idRacao;

    public PedidoDTO(Pedido pedido, UsuarioDTO usuario, List<RacaoDTO> idRacao) {
        this.id = pedido.getId();
        this.dtCompra = pedido.getDtCompra();
        this.precoTotal = pedido.getPrecoTotal();
        this.usuario = usuario;
        this.idRacao = idRacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDtCompra() {
        return dtCompra;
    }

    public void setDtCompra(Date dtCompra) {
        this.dtCompra = dtCompra;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public List<RacaoDTO> getIdRacao() {
        return idRacao;
    }

    public void setIdRacao(List<RacaoDTO> idRacao) {
        this.idRacao = idRacao;
    }
}
