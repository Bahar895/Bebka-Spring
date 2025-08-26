package com.bahar.Bebka_Spring.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
@JsonBackReference
@ToString.Exclude
    private Student student;
}
