package com.cuevamangapp.cuevamanga.repository;

import com.cuevamangapp.cuevamanga.models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Optional;
import java.util.function.Function;

public interface UserRepository extends JpaRepository<User,Long> {

    //metodo que valida que un usuario exista en la DB buscandolo por email y password
   boolean existsByEmailAndPassword(String email, String password);
}
