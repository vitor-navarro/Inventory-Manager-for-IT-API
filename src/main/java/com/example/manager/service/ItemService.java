package com.example.manager.service;

import com.example.manager.dto.ItemDTO;
import com.example.manager.dto.UserDTO;
import com.example.manager.entity.ItemEntity;
import com.example.manager.entity.UserEntity;
import com.example.manager.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ItemDTO> getAllItens(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<ItemEntity> itemPage = itemRepository.findAll(pageable);
        return itemPage.stream().map(ItemDTO::new).toList();

    }

    public ItemEntity createItem(ItemDTO item){
        ItemEntity itemEntity = new ItemEntity(item);
        return itemRepository.save(itemEntity);
    }
}
