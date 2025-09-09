package com.bahar.Bebka_Spring.service;

import com.bahar.Bebka_Spring.dto.request.StudentRequest;
import com.bahar.Bebka_Spring.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse create(StudentRequest request);
    List<StudentResponse> findAll();
    StudentResponse findById(Long id);
    StudentResponse update(Long id, StudentRequest request);
    void delete(Long id);
}