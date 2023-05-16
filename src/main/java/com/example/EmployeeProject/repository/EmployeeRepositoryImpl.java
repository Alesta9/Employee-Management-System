package com.example.EmployeeProject.repository;

import com.example.EmployeeProject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    private final EntityManager entityManager;

    @Autowired
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
        List<Employee> employeeList = theQuery.getResultList();
        return employeeList;
    }

    @Override
    public Employee findById(Integer employeeId) {
        Employee theEmployee = entityManager.find(Employee.class,employeeId);
        return theEmployee;
    }

    @Override
    public void addEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteEmployeeById(int employeeId) {
        Employee theEmployee = entityManager.find(Employee.class,employeeId);
        entityManager.remove(theEmployee);
    }
}
