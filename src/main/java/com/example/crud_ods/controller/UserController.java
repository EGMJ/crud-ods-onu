package com.example.crud_ods.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.crud_ods.ResourceNotFoundException;
import com.example.crud_ods.domain.User;
import com.example.crud_ods.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public User addNewUser(@RequestBody User user){
        return userRepository.save(user);
    }

    // Listar todos os usuarios existentes
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    // listar usuario por id
    @GetMapping(path="/user/{id}")
    public @ResponseBody Optional<User> getUser(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    // alterar dados por id do usuario
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User userDetails) {
        User updateUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));

        updateUser.setName(userDetails.getName());
        updateUser.setEmail(userDetails.getEmail());
        updateUser.setPassoword(userDetails.getPassoword());
        updateUser.setTreinos(userDetails.getTreinos());
        updateUser.setDadosMed(userDetails.getDadosMed());

        userRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }

    // Deletar usuario por id
    @DeleteMapping("/user/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer id){

        User userDel = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        userRepository.delete(userDel);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}