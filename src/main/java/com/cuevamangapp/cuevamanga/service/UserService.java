package com.cuevamangapp.cuevamanga.service;

import com.cuevamangapp.cuevamanga.models.User;
import com.cuevamangapp.cuevamanga.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<User> validateUser(String email, String password){
        User user = userRepository.findByEmail(email).orElse(null);
        if (user==null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);



        return new ResponseEntity<>(user,HttpStatus.OK);
    }

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
