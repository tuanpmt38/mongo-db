package com.example.demo.repository;

import com.example.demo.model.Customer;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

   Customer findByFirstName(String firstName);
   List<Customer> findByLastName(String lastName);

}
