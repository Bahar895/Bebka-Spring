package com.bahar.Bebka_Spring.service;

import com.bahar.Bebka_Spring.model.Employee;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {
    Employee create(Employee e);
    List<Employee> getAll();
    Employee getById(Long id);
    Employee update(Long id, Employee e);
    void delete(Long id);

    List<Employee> findByFirstNameContaining(String name);
    List<Employee> findByDepartment(String department);
    List<Employee> findBySalaryGreaterThan(BigDecimal amount);
    List<Employee> findByDepartmentNative(String dept);
    Page<Employee> getAll(Pageable pageable);
    Employee createRequired(Employee e);
    Employee createRequiresNew(Employee e);
    List<Employee> readWithSupports();

}
