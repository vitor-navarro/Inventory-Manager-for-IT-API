package com.example.manager.controllers;

import com.example.manager.dto.UserCreateDTO;
import com.example.manager.dto.UserDTO;
import com.example.manager.entity.UserEntity;
import com.example.manager.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
@Tag(name = "Usuários", description = "UserController")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Obtém um usuário pelo id dele", description = "Retorna as informações do usuário com base no id")
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @Operation(summary = "Obtém todos os usuários", description = "Retorna uma lista de todos os usuários cadastrados.")
    @GetMapping("/")
    public List<UserDTO> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return userService.getAllUsers(page, size);
    }

    @Operation(summary = "Obtém a quantidade de usuários cadastrados", description = "Retorna a quantidade de usuários cadastrados.")
    @GetMapping("/total")
    public long countUsers(){
        return userService.countUsers();
    }

    @Operation(summary = "Cria um usuário", description = "Cria um usuário no database, Não é necessário enviar ID")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity createUser(@Valid @RequestBody UserCreateDTO user){
        return userService.createUser(user);
    }
}
