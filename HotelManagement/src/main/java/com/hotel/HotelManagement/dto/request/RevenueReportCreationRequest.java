package com.hotel.HotelManagement.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RevenueReportCreationRequest {
    @NotBlank(message = "room type name cannot be blank")
    private String roomTypeName;

    @NotNull(message = "month cannot be null")
    private Date month;

    @NotNull(message = "revenue cannot be null")
    @Min(value = 0, message = "revenue must be positive")
    private int revenue;

    @NotNull(message = "percentage cannot be null")
    @Min(value = 0, message = "percentage must be positive")
    private double percentage;
}
