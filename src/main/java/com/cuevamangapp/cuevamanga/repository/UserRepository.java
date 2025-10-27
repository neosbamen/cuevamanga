package com.cuevamangapp.cuevamanga.repository;

import com.cuevamangapp.cuevamanga.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    //metodo que valida que un usuario exista en la DB buscandolo por email y password
    boolean findByEmailAndPassword(String email,String password);
}
