package com.example.Lanchonete.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Lanchonete.modelo.Cliente;
import com.example.Lanchonete.modelo.Item;
import com.example.Lanchonete.modelo.Pedido;
import com.example.Lanchonete.repositorio.ClienteRepositorio;
import com.example.Lanchonete.repositorio.ItemRepositorio;
import com.example.Lanchonete.repositorio.PedidoRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoServico {

    private final PedidoRepositorio pedidoRepositorio;
    private final ItemRepositorio itemRepositorio;
    private final ClienteRepositorio clienteRepositorio;

    public PedidoServico(ClienteRepositorio clienteRepositorio, ItemRepositorio itemRepositorio, PedidoRepositorio pedidoRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
        this.itemRepositorio = itemRepositorio;
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public Pedido realizarPedido(Long idCliente, Long idItem, int quantidade) {
        Cliente cliente = clienteRepositorio.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Erro ao buscar Cliente"));

        Item item = itemRepositorio.findById(idItem)
                .orElseThrow(() -> new EntityNotFoundException("Erro ao buscar Item"));

        if (quantidade <= item.getQuantidadeEstoque()) {
            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            pedido.setItemPedido(item);
            pedido.setQuantidade(quantidade);
            pedido.setStatusPedido('A');
            item .setQuantidadeEstoque(item.getQuantidadeEstoque() - quantidade);
            itemRepositorio.save(item);
            return pedidoRepositorio.save(pedido);
        }else{
            System.out.println("Quantidade em estoque insuficiente");
            return null;
        }

    }

    public List<Pedido> listarPedidos() {
        return pedidoRepositorio.findAll();
    }

    public List<Pedido> listarPedidosPorStatus(char status) { //A para Pedido ABERTO F para Pedido ENCERRADO
        return pedidoRepositorio.listarPedidosPorStatus(status);
    }

    public Pedido alterarStatusPedido(Long idPedido, char statusPedido) {
        Pedido pedido = pedidoRepositorio.findById(idPedido)
                .orElseThrow(() -> new EntityNotFoundException("Erro ao buscar Pedido"));
        if (pedido != null) {
            pedido.setStatusPedido(statusPedido);
            return pedidoRepositorio.save(pedido);

        } else {
            return null;
        }
    }

    public List<Pedido> listarPedidosPorCliente(Long idCLiente) {
        return pedidoRepositorio.listarPedidosPorCliente(idCLiente);
    }

}
