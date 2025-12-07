package com.cuevamangapp.cuevamanga.controller;

import com.cuevamangapp.cuevamanga.models.User;
import com.cuevamangapp.cuevamanga.models.UserDTO;
import com.cuevamangapp.cuevamanga.service.UserService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;



    //Paso los atributos por pathParam, pero podria ser por requestBody o pathVariable. Revisar que conviene mas.
    @PostMapping("/validate")
    public ResponseEntity<Boolean> validateUserC(@RequestBody User user){

        return userService.validateUser(user.getEmail(), user.getPassword());
    }


    @PostMapping("/create")
    public ResponseEntity<String> createUserC(@RequestBody User user){

        return userService.createUser(user);
    }

    @PutMapping("/update{id}")
    public ResponseEntity<String> updateUserC(@PathVariable Long id, @RequestBody User user){

        return userService.updateUser(id,user);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUserC(@RequestParam Long id){

        return userService.deleteUser(id);
    }
    
}
