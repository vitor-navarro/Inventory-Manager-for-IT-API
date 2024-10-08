package com.example.manager.dto;

import com.example.manager.entity.ItemEntity;
import com.example.manager.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter @Setter
@Hidden
public class ItemDTO {


    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    @NotNull
    @NotBlank
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("amount")
    @NotNull
    private Double amount;

    @JsonProperty("storageLocation")
    private String storageLocation;

    public ItemDTO(){}

    public ItemDTO(ItemEntity item){
        BeanUtils.copyProperties(item, this);
    }
}
