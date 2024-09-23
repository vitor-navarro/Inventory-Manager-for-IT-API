package com.example.manager.service;

import com.example.manager.dto.ItemDTO;
import com.example.manager.entity.ItemEntity;
import com.example.manager.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemDTO getItem(int id){
        if(itemRepository.findById(id).isPresent()){
            ItemEntity itemEntity = itemRepository.findById(id).get();
            return new ItemDTO(itemEntity);
        }
        return new ItemDTO();
    }

    public ItemEntity createItem(ItemDTO item){
        ItemEntity itemEntity = new ItemEntity(item);
        return itemRepository.save(itemEntity);
    }
}
