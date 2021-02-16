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

    //http://localhost:2019/customers/customer/{customerid}
    // returns a customer by id
    @GetMapping(value = "/customer/{customerid}", produces = "application/json")
    public ResponseEntity<?> getCustomerById(@PathVariable long customerid)
    {
        Customer customer = customerServices.getCustomerById(customerid);
        return new ResponseEntity<>(customer,
            HttpStatus.OK);
    }

    //http://localhost:2019/customers/namelike/{custname}
    // returns a customer by id
    @GetMapping(value = "/namelike/{custname}", produces = "application/json")
    public ResponseEntity<?> getCustomerByNameLike(@PathVariable String custname)
    {
        List<Customer> customerList = customerServices.findByNameLike(custname);
        return new ResponseEntity<>(customerList,
            HttpStatus.OK);
    }

}
