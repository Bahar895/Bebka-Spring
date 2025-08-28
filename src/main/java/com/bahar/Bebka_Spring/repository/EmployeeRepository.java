package com.bahar.Bebka_Spring.repository;

import com.bahar.Bebka_Spring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {}

