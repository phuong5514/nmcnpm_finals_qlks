package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.CustomerType;
import com.hotel.HotelManagement.repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> getAllCustomerTypes() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findCustomerTypeById(String id) {
        return customerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<CustomerType> findCustomerTypesByName(String name) {
        return customerTypeRepository.findCustomerTypesByCustomerTypeNameContaining(name);
    }

    @Override
    public CustomerType save(CustomerType customerType) {
        return customerTypeRepository.save(customerType);
    }

    @Override
    public void delete(CustomerType customerType) {
        customerTypeRepository.delete(customerType);
    }

    @Override
    public void delete(String id) {
        customerTypeRepository.deleteById(id);
    }
}
