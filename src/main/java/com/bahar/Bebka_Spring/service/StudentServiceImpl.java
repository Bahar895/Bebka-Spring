package com.bahar.Bebka_Spring.service.impl;

import com.bahar.Bebka_Spring.dto.request.StudentRequest;
import com.bahar.Bebka_Spring.dto.response.StudentResponse;
import com.bahar.Bebka_Spring.model.Student;
import com.bahar.Bebka_Spring.repository.StudentRepository;
import com.bahar.Bebka_Spring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    // CREATE
    @Override
    @Transactional
    public StudentResponse create(StudentRequest request) {
        Student student = modelMapper.map(request, Student.class);
        Student saved = studentRepository.save(student);
        return modelMapper.map(saved, StudentResponse.class);
    }

    // FIND ALL
    @Override
    @Transactional(readOnly = true)
    public List<StudentResponse> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(s -> modelMapper.map(s, StudentResponse.class))
                .collect(Collectors.toList());
    }

    // FIND BY ID
    @Override
    @Transactional(readOnly = true)
    public StudentResponse findById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return modelMapper.map(student, StudentResponse.class);
    }

    // UPDATE
    @Override
    @Transactional
    public StudentResponse update(Long id, StudentRequest request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        // gelen request’ten field’leri set ediyoruz
        modelMapper.map(request, student);

        Student updated = studentRepository.save(student);
        return modelMapper.map(updated, StudentResponse.class);
    }

    // DELETE
    @Override
    @Transactional
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}