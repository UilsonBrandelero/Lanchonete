package com.example.Lanchonete.controle;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Lanchonete.modelo.Item;
import com.example.Lanchonete.servico.ItemServico;

@RestController
@RequestMapping("/item")
public class ItemControle {

    private final ItemServico itemServico;

    public ItemControle(ItemServico itemServico) {
        this.itemServico = itemServico;
    }

    @PostMapping("/cadastar_item")
    public Item cadastarItem(@RequestBody Item item) {
        return itemServico.cadastarItem(item);
    }

    @GetMapping("/listar_itens")
    public List<Item> listarItens() {
        return itemServico.listarItens();
    }

    @DeleteMapping("/deletar_item/{id}")
    public void deletarItem(Long id) {
        itemServico.deletarItem(id);
        
    
}

}
