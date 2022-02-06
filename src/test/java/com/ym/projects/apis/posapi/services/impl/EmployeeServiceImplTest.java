package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.BaseTestCase;
import com.ym.projects.apis.posapi.entity.*;
import com.ym.projects.apis.posapi.repositories.EmployeeRepository;
import com.ym.projects.apis.posapi.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class EmployeeServiceImplTest extends BaseTestCase {
    private Employee employee;

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl(employeeRepository);
        employee = Employee.builder()
                .id(ID).person(Person.builder().firstName("First Name").lastName("Last Name").middleName("middle Name").build())
                .address(Address.builder().address1("Address 1").address2("Address 2").build())
                .phone(Phone.builder().phone1("Phone 1").phone2("Phone 2").phone3("Phone 3").build())
                .role(Role.ADMIN)
                .build();
    }


    @Test
    void findAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        BDDMockito.given(employeeRepository.findAll()).willReturn(employeeList);
        employeeService.findAllEmployee();
        BDDMockito.then(employeeRepository).should(times(1)).findAll();

    }

    @Test
    void findEmployeeById() {
        BDDMockito.given(employeeRepository.findById(ID)).willReturn(Optional.of(employee));
        employeeService.findEmployeeById(ID);
        BDDMockito.then(employeeRepository).should(times(1)).findById(ID);
    }

    @Test
    void saveOrUpdateEmployee() {
        BDDMockito.given(employeeRepository.save(employee)).willReturn(employee);
        employeeService.saveOrUpdateEmployee(employee);
        BDDMockito.then(employeeRepository).should(times(1)).save(employee);

    }

    @Test
    void deleteEmployeeById() {
        employeeService.deleteEmployeeById(ID);
        verify(employeeRepository, times(1)).deleteById(ID);
    }
}