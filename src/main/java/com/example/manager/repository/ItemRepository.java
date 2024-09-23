package com.example.manager.repository;

import com.example.manager.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

}

