package com.example.Lanchonete.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Lanchonete.modelo.Item;
import com.example.Lanchonete.repositorio.ItemRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ItemServico {

    private final ItemRepositorio itemRepositorio;

    public ItemServico(ItemRepositorio itemRepositorio) {
        this.itemRepositorio = itemRepositorio;
    }

    public Item cadastarItem(Item item) {
        return itemRepositorio.save(item);

    }

    public List<Item> listarItens() {
        return itemRepositorio.findAll();
    }

    public Item buscarItemPorId(Long id) {
        return itemRepositorio.findById(id).get();
    }
    public Item editarItem(Item itemEditado, Long idItem){
       itemEditado.setId(idItem);
       return itemRepositorio.save(itemEditado); 
    }

    public Item deletarItem(Long id) {
        Item item = itemRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Erro ao buscar item para deletar"));
        itemRepositorio.delete(item);
        return item;
    }
    // public int buscaQuantidadeDisponivel(Long id){
    //     Item item = itemRepositorio.findById(id).get();
    //     int quantidadeDisponivel = item.getQuantidadeEstoque();
    //     return quantidadeDisponivel;
    // }
}
