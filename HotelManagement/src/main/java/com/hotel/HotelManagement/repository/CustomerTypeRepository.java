package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, String> {
}
