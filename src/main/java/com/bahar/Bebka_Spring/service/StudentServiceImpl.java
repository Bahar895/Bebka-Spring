package com.bahar.Bebka_Spring.service;

import com.bahar.Bebka_Spring.dto.request.StudentRequest;
import com.bahar.Bebka_Spring.dto.response.StudentResponse;
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
    public StudentResponse create(StudentRequest request) {
        Student s = toEntity(request);
        return toDto(repo.save(s));
    }

    @Override
    public List<StudentResponse> findAll() {
        return repo.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public StudentResponse findById(Long id) {
        Student s = repo.findById(id).orElseThrow();
        return toDto(s);
    }

    @Override
    public StudentResponse update(Long id, StudentRequest request) {
        Student s = repo.findById(id).orElseThrow();
        s.setName(request.getName());
        s.setEmail(request.getEmail());
        return toDto(repo.save(s));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // ---- mapping helpers
    private Student toEntity(StudentRequest r) {
        Student s = new Student();
        s.setName(r.getName());
        s.setEmail(r.getEmail());
        return s;
    }

    private StudentResponse toDto(Student s) {
        StudentResponse d = new StudentResponse();
        d.setId(s.getId());
        d.setName(s.getName());
        d.setEmail(s.getEmail());
        return d;
    }
}