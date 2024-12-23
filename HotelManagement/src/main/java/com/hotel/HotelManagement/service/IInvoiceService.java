package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IInvoiceService {
    List<Invoice> findInvoicesInMonth(int month, int year);
    List<Invoice> findInvoicesInYear(int year);

    Invoice save(Invoice invoice);
    void delete(Invoice invoice);
    void delete(int id);
}
