package edu.icet.crm.controller.customer;

import edu.icet.crm.model.Customer;
import edu.icet.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/add-customer")
    void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @GetMapping("/get-all-customers")
    List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/update-customer")
    void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete-customer/{id}")
    boolean deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }

    @GetMapping("/find-customer-by-id/{id}")
    Customer searchCustomerById(@PathVariable Long id) {
        return customerService.searchCustomerById(id);
    }
}