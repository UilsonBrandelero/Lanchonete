package com.example.Lanchonete.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Lanchonete.modelo.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

    @Query(value = "SELECT p  FROM pedido p WHERE p.status_pedido = :status", nativeQuery=true)
    List<Pedido> listarPedidosPorStatus(@Param("status") char status);
}
