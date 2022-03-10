package com.example.userapi.controller;

import com.example.userapi.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    public static List<UserDTO> users = new ArrayList<>();

    @PostConstruct
    public void initiateList() {
        UserDTO userDTO = new UserDTO();
        userDTO.setAddress("Address");
        userDTO.setCpf("000.000.000-00");
        userDTO.setEmail("email@domain.com");
        userDTO.setName("User");
        userDTO.setPhone("00000-0000");
        userDTO.setRegistrationDate(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setName("Luiz");
        userDTO2.setCpf("456");
        userDTO2.setAddress("Rua b");
        userDTO2.setEmail("luiz@email.com");
        userDTO2.setPhone("1234-3454");
        userDTO2.setRegistrationDate(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setName("Bruna");
        userDTO3.setCpf("678");
        userDTO3.setAddress("Rua c");
        userDTO3.setEmail("bruna@email.com");
        userDTO3.setPhone("1234-3454");
        userDTO3.setRegistrationDate(new Date());

        users.addAll(Arrays.asList(userDTO, userDTO2, userDTO3));
    }

    @GetMapping("/")
    public String getMessage() {
        return "Spring Boot is working!";
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return users;
    }

    @GetMapping("/users/{cpf}")
    public  UserDTO getUsersFilter(@PathVariable String cpf) {
        for(UserDTO userFilter: users){
            if(userFilter.getCpf().equals(cpf)){
                return userFilter;
            }
        }
        return null;
    }
}
