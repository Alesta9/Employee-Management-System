package com.example.EmployeeProject.service;

import com.example.EmployeeProject.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Integer employeeId);

    void addEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(int employeeId);
}
