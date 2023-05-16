package com.example.EmployeeProject.controller;

import com.example.EmployeeProject.entity.Employee;
import com.example.EmployeeProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping(path = "/employees/{employeeId}")
    public Employee findById(@PathVariable(required = true) Integer employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping(path = "/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping(path = "/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee dbEmployee = employeeService.updateEmployee(employee);
        return dbEmployee;
    }

    @DeleteMapping(path = "/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("employee with id " + employeeId + " does not exists");
        }
        employeeService.deleteEmployeeById(employeeId);
        return "the student with id : " + employeeId + " is deleted";
    }




}
