package com.example.Lanchonete.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Lanchonete.modelo.Cliente;
import com.example.Lanchonete.repositorio.ClienteRepositorio;

@Service
public class ClienteServico {

    private final ClienteRepositorio clienteRepositorio;

    public ClienteServico(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }

    public Cliente buscarClientePorId(Long id) {
        return clienteRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    }

    public Cliente deletrCliente(Long id) {
        Cliente cliente = clienteRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        clienteRepositorio.delete(cliente);
        return cliente;
    }

}
