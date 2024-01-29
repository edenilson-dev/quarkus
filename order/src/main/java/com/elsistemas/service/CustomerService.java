package com.elsistemas.service;

import com.elsistemas.dto.CustomerDto;
import com.elsistemas.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerDto> findAll() {
        List<CustomerDto> customers = new ArrayList<>();

        customerRepository.findAll().stream().forEach(item -> {
            customers.add(CustomerDto.to(item));
        });
        return customers;
    }


    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public void createNewCustomer(CustomerDto dto) {
        customerRepository.persist(CustomerDto.to(dto));
    }

    public void changeCustomers(Long id, CustomerDto dto) {
        var customer = customerRepository.findById(id);
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setAddress(dto.getAddress());
        customer.setAge(dto.getAge());
        customerRepository.persist(customer);
    }

    public CustomerDto findById(Long id) {
        return CustomerDto.to(customerRepository.findById(id));
    }
}
