package com.example.demo.service.impl;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerRepository repository;

  @Override
  public Customer save(CustomerDto customerDto) {
    Customer customer = new Customer();
    customer.setFirstName(customerDto.getFirstName());
    customer.setLastName(customerDto.getLastName());
    repository.save(customer);
    return customer;
  }

  @Override
  public List<Customer> findAll() {
    return repository.findAll();
  }

  @Override
  public Optional<Customer> findById(String id) {
    return repository.findById(id);
  }
}
