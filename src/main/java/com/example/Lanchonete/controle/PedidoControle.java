package com.example.Lanchonete.controle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Lanchonete.modelo.Pedido;
import com.example.Lanchonete.servico.PedidoServico;

@RestController
@RequestMapping("/pedido")
public class PedidoControle {
    private final PedidoServico pedidoServico;

    public PedidoControle(PedidoServico pedidoServico) {
        this.pedidoServico = pedidoServico;
    }
    
    public Pedido realizarPedido(@RequestParam Long idItem, @RequestParam Long idCliete, @RequestParam int quantidadePedida){
        return null;
    }
}
