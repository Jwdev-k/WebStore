package com.naka.webstore.domain.repository.impl;

import com.naka.webstore.domain.Customer;
import com.naka.webstore.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MariaCustomerRepository implements CustomerRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    public List<Customer> getAllCustomers() {
        Map<String, Object> params = new HashMap<String, Object>();
        List<Customer> result = jdbcTemplate.query("SELECT * FROM customers",
                        params, new CustomerMapper());
        return result;
    }

    private static final class CustomerMapper implements
            RowMapper<Customer> {
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerId(rs.getString("ID"));
            customer.setName(rs.getString("NAME"));
            customer.setAddress(rs.getString("address"));
            customer.setNoOfOrdersMade(rs.getInt("noOfOrdersMade"));
            return customer;
        }
    }

    public void addCustomer(Customer customer) {
        String SQL = "INSERT INTO customers "
                + "VALUES (:id, :c_name, :address, :noOfOrdersMade)";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", customer.getCustomerId());
        params.put("c_name", customer.getName());
        params.put("address", customer.getAddress());
        params.put("noOfOrdersMade", customer.getNoOfOrdersMade());
        jdbcTemplate.update(SQL, params);
    }
}

