package com.example.Lanchonete.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Lanchonete.modelo.Item;

public interface ItemRepositorio extends JpaRepository<Item, Long> {

}
