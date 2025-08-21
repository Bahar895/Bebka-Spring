package com.bahar.Bebka_Spring.service;

import com.bahar.Bebka_Spring.model.Student;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public interface StudentService {
    Student create (Student s);
    List<Student> findAll();
}
