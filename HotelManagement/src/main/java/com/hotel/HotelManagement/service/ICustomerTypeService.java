package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.CustomerType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomerTypeService {
    List<CustomerType> getAllCustomerTypes();
    CustomerType findCustomerTypeById(String id);

    CustomerType findCustomerTypeByName(String name);

    CustomerType save(CustomerType customerType);
    void delete(CustomerType customerType);
}
