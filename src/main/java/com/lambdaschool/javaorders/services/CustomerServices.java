package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;

import java.util.List;

public interface CustomerServices
{
    public Customer save(Customer customer);

    List<Customer> findAllCustomers();

    Customer getCustomerById(long id);

    List<Customer> findByNameLike(String likename);
}
