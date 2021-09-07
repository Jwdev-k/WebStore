package com.ezen.webstore.service.impl;

import com.ezen.webstore.domain.Customer;
import com.ezen.webstore.domain.repository.CustomerRepository;
import com.ezen.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

}
