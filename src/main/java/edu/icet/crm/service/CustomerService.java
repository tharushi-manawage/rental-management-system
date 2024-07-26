package edu.icet.crm.service;

import edu.icet.crm.model.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    void updateCustomer(Customer customer);

    boolean deleteCustomer(Long id);

    Customer searchCustomerById(Long id);
}