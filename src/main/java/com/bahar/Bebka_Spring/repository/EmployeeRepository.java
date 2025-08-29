package com.bahar.Bebka_Spring.repository;

import com.bahar.Bebka_Spring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
    List<Employee> findByFirstNameContaining(String name);
    List<Employee> findByDepartment(String department);
}

