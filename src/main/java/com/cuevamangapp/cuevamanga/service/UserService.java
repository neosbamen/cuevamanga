package com.cuevamangapp.cuevamanga.service;

import com.cuevamangapp.cuevamanga.models.User;
import com.cuevamangapp.cuevamanga.models.UserDTO;
import com.cuevamangapp.cuevamanga.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public ResponseEntity<Boolean> validateUser(String email, String password){


        boolean exist = userRepository.existsByEmailAndPassword(email,password);
        return new ResponseEntity<>(exist,HttpStatus.FOUND);
    }

    //metodo que crea usuarios en dataBase
    public ResponseEntity<String> createUser(User user){
        userRepository.save(user);
        return new ResponseEntity<>("User created successfully",HttpStatus.CREATED);
    }


    public ResponseEntity<String> updateUser(Long id,User user){

        Optional<User> userOptional=userRepository.findById(id);

        if (userOptional.isPresent()){
            userOptional.get().setEmail(user.getEmail());
            userOptional.get().setPassword(user.getPassword());
            userOptional.get().setName(user.getName());
            userRepository.save(userOptional.get());
            return new ResponseEntity<>("User updated successfully",HttpStatus.OK);
        }else {

            return new ResponseEntity<>("Not user match the provided Id",HttpStatus.CONFLICT);
        }


    }


    public ResponseEntity<String> deleteUser(Long id){

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()){

            userRepository.delete(userOptional.get());
            return new ResponseEntity<>("The user was delete successfully",HttpStatus.OK);
        }else {

            return new ResponseEntity<>("Not user match the provided Id",HttpStatus.CONFLICT);
        }
    }
}
