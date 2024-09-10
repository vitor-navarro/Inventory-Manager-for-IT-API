package com.example.manager.dto;

import com.example.manager.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("username")
    @NotNull
    @NotBlank
    private String username; //Pode ser usado no login

    @JsonProperty("email")
    @Email(message = "Email should be valid")
    private String email; //Pode ser usado no login

    public UserDTO(){}

    public UserDTO(UserEntity user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}