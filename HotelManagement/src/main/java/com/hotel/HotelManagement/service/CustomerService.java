package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.Customer;
import com.hotel.HotelManagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findCustomerById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer findCustomerByIdCard(String idCard) {
        return customerRepository.findByIdentityCard(idCard);
    }

    @Override
    public List<Customer> findCustomerByName(String customerName) {
        return customerRepository.findByCustomerNameContains(customerName);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }
}
