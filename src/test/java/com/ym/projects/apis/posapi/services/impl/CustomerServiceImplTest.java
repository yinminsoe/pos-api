package com.ym.projects.apis.posapi.services.impl;

import com.ym.projects.apis.posapi.BaseTestCase;
import com.ym.projects.apis.posapi.model.Address;
import com.ym.projects.apis.posapi.model.Customer;
import com.ym.projects.apis.posapi.model.Person;
import com.ym.projects.apis.posapi.model.Phone;
import com.ym.projects.apis.posapi.repositories.CustomerRepository;
import com.ym.projects.apis.posapi.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


class CustomerServiceImplTest extends BaseTestCase {
    private Customer customer;
    @Mock
    private CustomerRepository customerRepository;

    private CustomerService customerService;


    @BeforeEach
    void setUp() {
        customer = Customer.builder()
                .id(ID).person(Person.builder().firstName("First Name").lastName("Last Name").middleName("middle Name").build())
                .address(Address.builder().address1("Addresss 1").address2("Delivery addres 1").build())
                .phone(Phone.builder().phone1("+65-2343243").phone2("+65-234343").phone3("+65-2343").build())
                .build();
        customerService = new CustomerServiceImpl(customerRepository);
    }

    @Test
    void findAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        BDDMockito.given(customerRepository.findAll()).willReturn(customers);
        customerService.findAllCustomer();
        BDDMockito.then(customerRepository).should().findAll();
    }

    @Test
    void findCustomerById() {
        BDDMockito.given(customerRepository.findById(ID)).willReturn(Optional.of(customer));
        customerService.findCustomerById(ID);
        BDDMockito.then(customerRepository).should().findById(ID);
    }

    @Test
    void saveOrUpdateCustomer() {
        BDDMockito.given(customerRepository.save(any(Customer.class))).willReturn(customer);
        customerService.saveOrUpdateCustomer(customer);
        BDDMockito.then(customerRepository).should(times(1)).save(customer);
    }

    @Test
    void deleteCusomterById() {
        doNothing().when(customerRepository).deleteById(anyLong());
        customerService.deleteCusomterById(ID);
        verify(customerRepository, times(1)).deleteById(ID);
    }
}