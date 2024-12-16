package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
