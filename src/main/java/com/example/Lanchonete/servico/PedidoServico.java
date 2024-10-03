package com.example.Lanchonete.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Lanchonete.modelo.Pedido;
import com.example.Lanchonete.repositorio.PedidoRepositorio;

@Service
public class PedidoServico {

    private final PedidoRepositorio pedidoRepositorio;

    public PedidoServico(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public Pedido realizarPedido(Pedido pedido) {
        return pedidoRepositorio.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepositorio.findAll();
    }
    
    public List<Pedido> listarPedidosPorStatus(char status){ //A para Pedido ABERTO F para Pedido ENCERRADO
        return pedidoRepositorio.listarPedidosPorStatus(status);
    }

}
