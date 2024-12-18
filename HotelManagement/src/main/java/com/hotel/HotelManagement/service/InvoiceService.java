package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.Invoice;
import com.hotel.HotelManagement.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService implements IInvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> findInvoicesInMonth(int month, int year) {
        return invoiceRepository.findInvoicesInMonth(month, year);
    }

    @Override
    public List<Invoice> findInvoicesInYear(int year) {
        return invoiceRepository.findInvoicesInYear(year);
    }

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public void delete(Invoice invoice) {
        invoiceRepository.delete(invoice);
    }
}
