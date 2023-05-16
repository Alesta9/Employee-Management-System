package com.example.EmployeeProject.repository;

import com.example.EmployeeProject.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();

    Employee findById(Integer employeeId);

    void addEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(int employeeId);
}
