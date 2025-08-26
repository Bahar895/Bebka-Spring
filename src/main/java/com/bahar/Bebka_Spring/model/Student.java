package com.bahar.Bebka_Spring.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private String email;

    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
    @JsonManagedReference
    @ToString.Exclude
    private List<Book> books = new ArrayList<>();

}
