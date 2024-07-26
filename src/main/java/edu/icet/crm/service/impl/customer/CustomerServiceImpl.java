package edu.icet.crm.service.impl.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.model.Customer;
import edu.icet.crm.repository.CustomerRepository;
import edu.icet.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ObjectMapper mapper;

    @Override
    public void addCustomer(Customer customer) {
        CustomerEntity customerEntity = mapper.convertValue(customer, CustomerEntity.class);
        customerRepository.save(customerEntity);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList();
        Iterable<CustomerEntity> all = customerRepository.findAll();

        all.forEach(customerEntity -> {
            Customer customer = mapper.convertValue(customerEntity, Customer.class);
            customerList.add(customer);
        });
        return customerList;
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (customerRepository.existsById(customer.getId())) {
            CustomerEntity customerEntity = mapper.convertValue(customer, CustomerEntity.class);
            customerRepository.save(customerEntity);
        }
    }

    @Override
    public boolean deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Customer searchCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            Optional<CustomerEntity> byId = customerRepository.findById(id);
            return mapper.convertValue(byId, Customer.class);
        }
        return null;
    }
}