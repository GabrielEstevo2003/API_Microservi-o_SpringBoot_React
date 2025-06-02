package com.example.Pedidos.Repositories;

import com.example.Pedidos.Models.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
