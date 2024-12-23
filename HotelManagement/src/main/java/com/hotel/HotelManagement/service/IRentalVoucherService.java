package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.RentalVoucher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRentalVoucherService {
    List<RentalVoucher> getRentalVouchers();
    List<RentalVoucher> findRentalVouchersByStatus(RentalVoucher.Status status);

    RentalVoucher save(RentalVoucher rentalVoucher);
    void delete(RentalVoucher rentalVoucher);
    void delete(int id);
}
