package com.example.demo.service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

   Customer save (CustomerDto customer);

   List<Customer> findAll();

   Optional<Customer> findById(String id);

}
