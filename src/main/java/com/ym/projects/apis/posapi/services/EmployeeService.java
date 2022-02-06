package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployee();
    Employee findEmployeeById(Long id);
    Employee saveOrUpdateEmployee(Employee itemCategory);
    void deleteEmployeeById(Long id);
}
