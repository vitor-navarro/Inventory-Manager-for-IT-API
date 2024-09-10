package com.example.manager.entity;

import com.example.manager.dto.UserCreateDTO;
import com.example.manager.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "Users")
@Getter @Setter
public class UserEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false, unique = true)
        private String username; //Pode ser usado no login

        @Column(unique = true)
        private String email; //Pode ser usado no login

        @Column(nullable = false)
        private String password;

        public UserEntity(){

        }

        public UserEntity(UserDTO user){
                BeanUtils.copyProperties(user, this);
        }

        public UserEntity(UserCreateDTO user){
                BeanUtils.copyProperties(user, this);
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                UserEntity that = (UserEntity) o;
                return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(email, that.email);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, username, email);
        }

        @Override
        public String toString() {
                return "UserEntity{" +
                        "id=" + id +
                        ", username='" + username + '\'' +
                        ", email='" + email + '\'' +
                        '}';
        }
}
