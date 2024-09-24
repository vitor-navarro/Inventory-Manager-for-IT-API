package com.example.manager.controllers;

import com.example.manager.dto.ItemDTO;
import com.example.manager.entity.ItemEntity;
import com.example.manager.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/inventory")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/{id}")
    public ItemDTO getItem(@PathVariable int id){
        return itemService.getItem(id);
    }

    @GetMapping("/")
    public List<ItemDTO> getAllItens(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return itemService.getAllItens(page, size);
    }
    @GetMapping("/count")
    public long countItens(){
        return itemService.countItens();
    }

    @PostMapping("/")
    public ItemEntity createItem(@Valid @RequestBody ItemDTO item){
        return itemService.createItem(item);
    }

    @PostMapping("/updateItem")
    public ItemDTO updateItem(@Valid @RequestBody ItemDTO item){
        return itemService.updateItem(item);
    }

}
