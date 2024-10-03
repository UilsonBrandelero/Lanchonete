package com.example.Lanchonete.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Lanchonete.modelo.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
