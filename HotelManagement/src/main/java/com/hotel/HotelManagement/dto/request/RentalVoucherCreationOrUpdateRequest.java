package com.hotel.HotelManagement.dto.request;

import com.hotel.HotelManagement.entity.Customer;
import com.hotel.HotelManagement.entity.RentalVoucher;
import com.hotel.HotelManagement.entity.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RentalVoucherCreationOrUpdateRequest {
    private int voucherId;
    private int customerId;
    private int roomId;
    private Date startDate;
    private String statusString;

}
