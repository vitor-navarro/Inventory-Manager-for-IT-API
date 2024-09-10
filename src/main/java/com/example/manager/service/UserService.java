package com.example.manager.service;

import com.example.manager.dto.UserCreateDTO;
import com.example.manager.dto.UserDTO;
import com.example.manager.entity.UserEntity;
import com.example.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserCreateDTO user){
        UserEntity userEntity = new UserEntity(user);
        return userRepository.save(userEntity);
    }

    public UserDTO getUser(int id){
        if(userRepository.findById(id).isPresent()){
            UserEntity userEntity = userRepository.findById(id).get();
            return new UserDTO(userEntity);
        }
        return new UserDTO();
    }

    public List<UserDTO> getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserEntity> userPage = userRepository.findAll(pageable);
        return userPage.stream().map(UserDTO::new).toList();
    }

    public long countUsers(){
        return userRepository.count();
    }
}
