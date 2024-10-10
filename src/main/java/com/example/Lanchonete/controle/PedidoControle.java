package com.example.Lanchonete.controle;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping("/realizar_pedido")
    public Pedido realizarPedido(@RequestParam Long idCliente, @RequestParam Long idItem, @RequestParam int quantidade) {
        return pedidoServico.realizarPedido(idCliente, idItem, quantidade);

    }

    @GetMapping("/listar_pedidos")
    public List<Pedido> listarPedidos() {
        return pedidoServico.listarPedidos();
    }

    @PutMapping("/alterar_status_pedido")
    public Pedido alteraStatusPedido(@RequestParam Long idPedido, @RequestParam char statusPedido) {

        return pedidoServico.alterarStatusPedido(idPedido, statusPedido);
    }
    @GetMapping("/listar_pedidos_status/{status}")
    public List<Pedido> listarPedidosPorStatus(@PathVariable char status){
        return pedidoServico.listarPedidosPorStatus(status);
    }
    @GetMapping("/lista_pedidos_por_cliente/{id}")
    public List<Pedido> listarPedidosPorCliente(@PathVariable Long id){
        return pedidoServico.listarPedidosPorCliente(id);
    }
}
