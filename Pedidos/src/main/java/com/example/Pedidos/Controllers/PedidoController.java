package com.example.Pedidos.Controllers;

import com.example.Pedidos.DTOs.PedidoCriacaoDTO;
import com.example.Pedidos.DTOs.RacaoDTO;
import com.example.Pedidos.DTOs.UsuarioDTO;
import com.example.Pedidos.Models.Pedido;
import com.example.Pedidos.DTOs.PedidoDTO;
import com.example.Pedidos.Services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("API-Microservico/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> criarPedido(@RequestBody PedidoCriacaoDTO pedidoDTO) {
        Pedido pedidoSalvo = pedidoService.salvarPedido(pedidoDTO);
        return ResponseEntity.ok("Pedido criado com sucesso! ID: " + pedidoSalvo.getId());
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<PedidoDTO> listarPedidosPorUsuario(@PathVariable("idUsuario") Long idUsuario) {
        return pedidoService.listarPedidosPorUsuario(idUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Long id) {
        PedidoDTO detalhes = pedidoService.buscarPedidoDetalhado(id);
        return ResponseEntity.ok(detalhes);
    }
}
