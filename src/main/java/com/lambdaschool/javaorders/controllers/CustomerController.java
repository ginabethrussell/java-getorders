package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    private CustomerServices customerServices;

    //http://localhost:2019/customers/orders
    // returns a list of all customers including their orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> getAllCustomers()
    {
        List<Customer> customerList = customerServices.findAllCustomers();
        return new ResponseEntity<>(customerList,
            HttpStatus.OK);
    }

    //http://localhost:2019/customers/customer/{id}
    // returns a customer by id
    @GetMapping(value = "/customer/{id}", produces = "application/json")
    public ResponseEntity<?> getCustomerById(@PathVariable long id)
    {
        Customer customer = customerServices.getCustomerById(id);
        return new ResponseEntity<>(customer,
            HttpStatus.OK);
    }

    //http://localhost:2019/customers/namelike/{likename}
    // returns a customer by id
    @GetMapping(value = "/namelike/{likename}", produces = "application/json")
    public ResponseEntity<?> getCustomerByNameLike(@PathVariable String likename)
    {
        List<Customer> customerList = customerServices.findByNameLike(likename);
        return new ResponseEntity<>(customerList,
            HttpStatus.OK);
    }

}
