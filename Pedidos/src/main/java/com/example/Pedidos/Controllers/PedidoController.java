package com.example.Pedidos.Controllers;

import com.example.Pedidos.DTOs.PedidoCriacaoDTO;
import com.example.Pedidos.DTOs.RacaoDTO;
import com.example.Pedidos.DTOs.UsuarioDTO;
import com.example.Pedidos.Models.Pedido;
import com.example.Pedidos.DTOs.PedidoDTO;
import com.example.Pedidos.Services.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("API-Microservico/pedido")
@Tag(name = "Pedido", description = "Gerenciamento de Pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @Operation(
            summary = "Cria um pedido",
            description = "Retorna o objeto de um pedido."
    )
    @PostMapping
    public ResponseEntity<?> criarPedido(@RequestBody PedidoCriacaoDTO pedidoDTO) {
        Pedido pedidoSalvo = pedidoService.salvarPedido(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }

    @Operation(
            summary = "Listar todos os pedidos de um usuário",
            description = "Retorna uma lista de pedidos com informações do usuário e das rações"
    )
    @GetMapping("/usuario/{idUsuario}")
    public List<PedidoDTO> listarPedidosPorUsuario(@PathVariable("idUsuario") Long idUsuario) {
        return pedidoService.listarPedidosPorUsuario(idUsuario);
    }

    @Operation(
            summary = "Lista um pedido detalhado",
            description = "Retorna um pedido com detalhes de usuario e produto"
    )
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Long id) {
        PedidoDTO detalhes = pedidoService.buscarPedidoDetalhado(id);
        return ResponseEntity.ok(detalhes);
    }
}
