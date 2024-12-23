package com.hotel.HotelManagement.dto.request;

import com.hotel.HotelManagement.entity.CustomerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
