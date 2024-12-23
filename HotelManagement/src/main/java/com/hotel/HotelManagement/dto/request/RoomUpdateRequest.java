package com.hotel.HotelManagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class RoomUpdateRequest {
    private int roomId;
    private String roomStatusString;
    private String roomTypeString;

}
