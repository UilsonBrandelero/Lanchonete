package com.example.Lanchonete.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Lanchonete.modelo.Cliente;
import com.example.Lanchonete.modelo.Item;
import com.example.Lanchonete.modelo.Pedido;
import com.example.Lanchonete.repositorio.ClienteRepositorio;
import com.example.Lanchonete.repositorio.ItemRepositorio;
import com.example.Lanchonete.repositorio.PedidoRepositorio;

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

    public Pedido realizarPedido(List<Long> idItens, Long idCliente, List<Integer> quantidadePedida) {
        List<Item> itensPedidos = null;
        Cliente cliente = clienteRepositorio.findById(idCliente)
                .orElseThrow(() -> new IllegalArgumentException("Cliente nao encontrado"));
        for (Long id : idItens) {
            Item item = itemRepositorio.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));
            if (item.getQuantidadeEstoque() >= item.getQuantidadePedida()) {
                
                itensPedidos.add(item);

            }else{
                System.out.println("Qunatidade em estoque não suficiente");
            }
        }
        if(itensPedidos!= null){
            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            pedido.setItensPedidos(itensPedidos);

            return pedidoRepositorio.save(pedido);
        }else{
            System.out.println("Erro ao realizar pedido");
            return null;
        }

    }

    public List<Pedido> listarPedidos() {
        return pedidoRepositorio.findAll();
    }

    public List<Pedido> listarPedidosPorStatus(char status) { //A para Pedido ABERTO F para Pedido ENCERRADO
        return pedidoRepositorio.listarPedidosPorStatus(status);
    }

}
