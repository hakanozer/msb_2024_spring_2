package com.works.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Column(length = 100)
    private String name;

    @NotNull
    @NotEmpty
    @Email
    @Column(unique = true, length = 100)
    private String email;

    @Size(min = 3, max = 15)
    @NotNull
    @NotEmpty
    @Column(length = 15)
    private String password;

    private Integer age;

}
