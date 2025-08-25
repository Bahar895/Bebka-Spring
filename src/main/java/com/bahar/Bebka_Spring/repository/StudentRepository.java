package com.bahar.Bebka_Spring.repository;

import com.bahar.Bebka_Spring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
