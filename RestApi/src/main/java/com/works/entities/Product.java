package com.works.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Size(min = 3, max = 100)
    @NotEmpty(message = "Title boş olamaz!")
    @NotNull(message = "Title nesnesi yok!")
    private String title;

    @Size(min = 5, max = 500)
    @NotEmpty
    @NotNull
    private String description;

    @Max(1000000)
    @Min(1)
    @NotNull
    private Integer price;

}
