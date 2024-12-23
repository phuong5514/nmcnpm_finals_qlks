package com.hotel.HotelManagement.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegulationUpdateRequest {
    private int defaultMaxGuestCount;
    private double defaultOverGuestRate;

}
