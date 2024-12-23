package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomerService {
    List<Customer> getCustomers();
    Customer findCustomerById(int id);
    Customer findCustomerByIdCard(String idCard);
    List<Customer> findCustomerByName(String customerName);


    Customer save(Customer customer);
    void delete(Customer customer);
    void delete(int id);

}
