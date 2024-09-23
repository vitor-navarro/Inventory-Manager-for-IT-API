package com.example.manager.controllers;

import com.example.manager.dto.ItemDTO;
import com.example.manager.dto.UserCreateDTO;
import com.example.manager.entity.ItemEntity;
import com.example.manager.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/inventory")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/{id}")
    public ItemDTO getItem(@PathVariable int id){
        return itemService.getItem(id);
    }

    @PostMapping("/")
    public ItemEntity createItem(@Valid @RequestBody ItemDTO item){
        return itemService.createItem(item);
    }

}
