package com.example.demo.controller;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CustomerController {

  @Autowired
  CustomerService customerService;

  @Autowired
  CustomerRepository repository;

  @GetMapping(value = "customers")
  public List<Customer> getAllPets() {
    return customerService.findAll();
  }

  @PostMapping(value = "customer")
  public Customer create(@RequestBody Customer customer) {
    return repository.save(customer);
  }

  @GetMapping(value = "customer/{id}")
  public Optional<Customer> getCustomerById(@PathVariable("id") String id) {
    return customerService.findById(id);
  }

}
