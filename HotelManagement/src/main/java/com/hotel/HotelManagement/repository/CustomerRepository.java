package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByIdentityCard(String identityCard);

    List<Customer> findByCustomerNameContains(String customerName);
}
