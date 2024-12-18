package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.RentalVoucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalVoucherRepository extends JpaRepository<RentalVoucher, Integer> {

    @Query("Select i from RentalVoucher i where i.status = :string")
    List<RentalVoucher> findRentalVouchersByStatus(String string);
}
