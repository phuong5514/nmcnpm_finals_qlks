package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType, String> {
    CustomerType findByCustomerTypeNameContaining(String customerTypeName);
}
