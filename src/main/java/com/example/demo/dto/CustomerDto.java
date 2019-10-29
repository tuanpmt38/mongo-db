package com.example.demo.dto;


import com.example.demo.model.Customer;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements Serializable {

  String firstName;
  String lastName;

  public CustomerDto(Customer customer) {
    this.firstName = customer.getFirstName();
    this.lastName = customer.getFirstName();
  }

}
