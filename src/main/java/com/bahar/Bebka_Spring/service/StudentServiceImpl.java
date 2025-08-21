package com.bahar.Bebka_Spring.service;


import com.bahar.Bebka_Spring.model.Student;
import com.bahar.Bebka_Spring.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repo;

    @Override
    public Student create(Student s) {
        if (s.getName() == null || s.getName().isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        return repo.save(s);
    }
    @Override
    public List<Student> findAll() {
        return repo.findAll();
    }
}
