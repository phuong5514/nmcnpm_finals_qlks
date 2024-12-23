package com.hotel.HotelManagement.dto.request;

import com.hotel.HotelManagement.entity.RoomType;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RevenueReportCreationOrUpdateRequest {
    private int revenueReportID;
    private RoomType roomType;
    private Date month;
    private int revenue;
    private double percentage;
}
