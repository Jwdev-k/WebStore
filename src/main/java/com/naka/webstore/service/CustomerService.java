package com.naka.webstore.service;

import com.naka.webstore.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    void addCustomer(Customer customer);
}
