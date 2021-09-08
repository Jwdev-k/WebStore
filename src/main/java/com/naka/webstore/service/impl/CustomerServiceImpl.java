package com.naka.webstore.service.impl;

import com.naka.webstore.domain.Customer;
import com.naka.webstore.domain.repository.CustomerRepository;
import com.naka.webstore.service.CustomerService;
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
