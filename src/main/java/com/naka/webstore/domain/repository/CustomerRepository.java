package com.naka.webstore.domain.repository;

import com.naka.webstore.domain.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();
}

