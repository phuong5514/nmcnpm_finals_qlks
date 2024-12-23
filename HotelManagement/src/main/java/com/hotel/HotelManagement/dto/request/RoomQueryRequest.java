package com.hotel.HotelManagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomQueryRequest {
    private String roomTypeName;
    private int roomId = -1;
    private String roomStatusString;
}
