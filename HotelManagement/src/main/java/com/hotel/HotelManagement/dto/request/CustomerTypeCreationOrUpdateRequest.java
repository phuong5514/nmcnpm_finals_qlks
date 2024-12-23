package com.hotel.HotelManagement.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerTypeCreationOrUpdateRequest {
    private String customerTypeID;
    private String customerTypeName;
    private double feeModifier;
}
