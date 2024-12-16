package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
