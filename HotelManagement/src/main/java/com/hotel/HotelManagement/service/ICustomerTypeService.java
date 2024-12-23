package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.CustomerType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomerTypeService {
    List<CustomerType> getAllCustomerTypes();
    CustomerType findCustomerTypeById(String id);

    List<CustomerType> findCustomerTypesByName(String name);

    CustomerType save(CustomerType customerType);
    void delete(CustomerType customerType);
    void delete(String id);
}
