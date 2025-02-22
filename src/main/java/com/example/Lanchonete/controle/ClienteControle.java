package com.example.Lanchonete.controle;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Lanchonete.modelo.Cliente;
import com.example.Lanchonete.servico.ClienteServico;

@RestController
@RequestMapping("/cliente")
public class ClienteControle {

    public final ClienteServico clienteServico;

    public ClienteControle(ClienteServico clienteServico) {
        this.clienteServico = clienteServico;
    }

    @PostMapping("/cadastrar_cliente")
    public Cliente cadasCliente(@RequestBody Cliente cliente) {
        return clienteServico.cadastrarCliente(cliente);
    }

    @GetMapping("/listar_clientes")
    public List<Cliente> listarClientes() {
        return clienteServico.listarClientes();

    }
    @GetMapping("/listar_por_id/{id}")
    public Cliente editarCliente(@PathVariable Long id){
        return clienteServico.buscarClientePorId(id);
    }
    @PutMapping("/editar_cliente/{id}")
    public Cliente editaCliente(@RequestBody Cliente clienteEditado, @PathVariable Long id){
        return clienteServico.editarCliente(clienteEditado, id);
    }

    @DeleteMapping("/deletar_cliente/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteServico.deletrCliente(id);
    }

}
