package com.cuevamangapp.cuevamanga.controller;

import com.cuevamangapp.cuevamanga.models.User;
import com.cuevamangapp.cuevamanga.models.UserDTO;
import com.cuevamangapp.cuevamanga.service.UserService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> userAsList(){
        return userService.userAsList();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUserC(@RequestBody User user){

        return userService.createUser(user);
    }

    @PutMapping("/update{id}")
    public ResponseEntity<String> updateUserC(@PathVariable Long id, @RequestBody User user){

        return userService.updateUser(id,user);
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<String> deleteUserC(@PathParam("id") Long id){

        return userService.deleteUser(id);
    }
    
}
