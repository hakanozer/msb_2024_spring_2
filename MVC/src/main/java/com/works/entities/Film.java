package com.works.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fid;

    private String title;
    private String fdate;

    @ManyToOne
    private Category category;


}
