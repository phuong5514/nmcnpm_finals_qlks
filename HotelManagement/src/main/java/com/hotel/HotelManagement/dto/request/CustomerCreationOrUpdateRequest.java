package com.hotel.HotelManagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerCreationOrUpdateRequest {
    private int customerId;
    private String identityCard;
    private String customerName;
    private String address;
    private String cutomerTypeString;

}
