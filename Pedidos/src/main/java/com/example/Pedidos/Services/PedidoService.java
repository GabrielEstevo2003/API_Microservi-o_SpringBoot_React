package com.example.Pedidos.Services;

import com.example.Pedidos.DTOs.PedidoCriacaoDTO;
import com.example.Pedidos.Models.ItemPedido;
import com.example.Pedidos.Models.Pedido;
import com.example.Pedidos.DTOs.PedidoDTO;
import com.example.Pedidos.DTOs.RacaoDTO;
import com.example.Pedidos.DTOs.UsuarioDTO;
import com.example.Pedidos.Repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Pedido salvarPedido(PedidoCriacaoDTO pedidoDTO) {

        Pedido pedido = new Pedido();
        pedido.setIdUsuario(pedidoDTO.getIdUsuario());
        pedido.setPrecoTotal(pedidoDTO.getPrecoTotal());
        pedido.setDtCompra(new Date());

        List<ItemPedido> itens = pedidoDTO.getItens().stream().map(itemDTO -> {
            ItemPedido item = new ItemPedido();
            item.setIdRacao(itemDTO.getIdRacao());
            item.setQuantidade(itemDTO.getQuantidade());
            item.setPedido(pedido);
            return item;
        }).collect(Collectors.toList());

        pedido.setItens(itens);

        return pedidoRepository.save(pedido);
    }
    public PedidoDTO buscarPedidoDetalhado(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        UsuarioDTO usuario = restTemplate.getForObject(
                "http://localhost:8081/API-Microservico/usuario/" + pedido.getIdUsuario(), UsuarioDTO.class);

        List<RacaoDTO> racoes = new ArrayList<>();

        for (Long idRacao : pedido.getIdRacao()) {
            RacaoDTO racao = restTemplate.getForObject(
                    "http://localhost:8082/API-Microservico/racao/" + idRacao, RacaoDTO.class);
            racoes.add(racao);
        }
        return new PedidoDTO(pedido, usuario, racoes);
    }
    public List<PedidoDTO> listarPedidosPorUsuario( Long idUsuario) {
        List<Pedido> pedidos = pedidoRepository.findByIdUsuario(idUsuario);
        return pedidos.stream().map(pedido -> {
            // Para cada Pedido, buscar o UsuarioDTO e a lista de RacaoDTO
            UsuarioDTO usuario = restTemplate.getForObject(
                    "http://localhost:8081/API-Microservico/usuario/" + pedido.getIdUsuario(),
                    UsuarioDTO.class
            );

            List<RacaoDTO> racaoDTOs = pedido.getItens().stream().map(item ->
                    restTemplate.getForObject(
                            "http://localhost:8082/API-Microservico/racao/" + item.getIdRacao(),
                            RacaoDTO.class
                    )
            ).toList();

            return new PedidoDTO(pedido, usuario, racaoDTOs);
        }).toList();
    }
    }
