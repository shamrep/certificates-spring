package org.certspring.controller;

import org.certspring.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @GetMapping("/{requestedId}")
  private ResponseEntity<Customer> findById(@PathVariable Long requestedId) {

    if(requestedId == 1) {
      return ResponseEntity.ok(new Customer(1,"test@email.com", "password"));
    }
    return ResponseEntity.notFound().build();

  }
}
