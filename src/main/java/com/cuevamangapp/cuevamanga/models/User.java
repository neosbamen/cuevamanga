package com.cuevamangapp.cuevamanga.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "name can't be empty")
    @NotNull(message = "name can't be null")
    private String name;
    @Column(unique = true)
    @Email(message = "not a valid email address")
    private String email;
    @NotBlank(message = "password can't be empty")
    @NotNull(message = "password can't be null")
    private String password;
}
