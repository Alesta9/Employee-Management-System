package com.example.EmployeeProject.service;

import com.example.EmployeeProject.entity.Employee;
import com.example.EmployeeProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer employeeId) {
        if(employeeId < 1) {
            throw new IllegalStateException("the user with id : " + employeeId + " does not exists.");
        }
        return employeeRepository.findById(employeeId);
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        var employeeId = employee.getId();
        if(employeeId != null) {
            Employee theEmployee = employeeRepository.findById(employeeId);
            if(theEmployee == null) {
                employeeRepository.addEmployee(employee);
            }
        }
        else {
            employeeRepository.addEmployee(employee);
        }


    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int employeeId) {
        employeeRepository.deleteEmployeeById(employeeId);
    }
}
