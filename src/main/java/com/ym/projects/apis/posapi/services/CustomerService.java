package com.ym.projects.apis.posapi.services;

import com.ym.projects.apis.posapi.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer();
    Customer findCustomerById(Long id);
    Customer saveOrUpdateCustomer(Customer customer);
    void deleteCusomterById(Long id);

}
