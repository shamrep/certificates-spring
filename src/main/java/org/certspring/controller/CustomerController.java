package org.certspring.controller;

import org.certspring.dao.CustomerRepository;
import org.certspring.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private final CustomerRepository customerRepository;

  private CustomerController(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @GetMapping("/{requestedId}")
  private ResponseEntity<Customer> findById(@PathVariable Long requestedId) {

    Optional<Customer> customerOptional = customerRepository.findById((requestedId));

    if(customerOptional.isPresent()) {
      return ResponseEntity.ok(customerOptional.get());
    }

    return ResponseEntity.notFound().build();
  }
}
