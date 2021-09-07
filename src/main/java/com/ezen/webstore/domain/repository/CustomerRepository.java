package com.ezen.webstore.domain.repository;

import com.ezen.webstore.domain.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();
}

