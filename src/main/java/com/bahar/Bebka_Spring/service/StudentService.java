package com.bahar.Bebka_Spring.service;

import com.bahar.Bebka_Spring.model.Student;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public interface StudentService {
    Student create (Student s);
    List<Student> findAll();
    Student findById(Long id);
    Student update(Long id,Student s);
    void delete(Long id);
}
