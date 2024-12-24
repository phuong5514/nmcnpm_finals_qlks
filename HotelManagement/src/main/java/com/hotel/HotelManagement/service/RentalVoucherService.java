package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.RentalVoucher;
import com.hotel.HotelManagement.repository.RentalVoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalVoucherService implements IRentalVoucherService {
    @Autowired
    private RentalVoucherRepository rentalVoucherRepository;

    @Override
    public RentalVoucher getRentalVoucher(int id) {
        return rentalVoucherRepository.findById(id).orElse(null);
    }

    @Override
    public List<RentalVoucher> getRentalVouchers() {
        return rentalVoucherRepository.findAll();
    }

    @Override
    public List<RentalVoucher> findRentalVouchersByStatus(RentalVoucher.Status status) {
        return rentalVoucherRepository.findRentalVouchersByStatus(status.toString());
    }

    @Override
    public RentalVoucher save(RentalVoucher rentalVoucher) {
        return rentalVoucherRepository.save(rentalVoucher);
    }

    @Override
    public void delete(RentalVoucher rentalVoucher) { rentalVoucherRepository.delete(rentalVoucher); }

    @Override
    public void delete(int id) { rentalVoucherRepository.deleteById(id); }
}
