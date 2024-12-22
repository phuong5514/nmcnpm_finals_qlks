package com.hotel.HotelManagement.controller.User;

import com.hotel.HotelManagement.entity.RoomType;
import com.hotel.HotelManagement.service.RoomService;
import com.hotel.HotelManagement.service.RoomTypeService;
import com.hotel.HotelManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserOwnerController {


    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    private RoomService roomService;

    @PostMapping("/create/room-type")
    public RoomType createRoomType(@RequestBody RoomType roomType) {
        return roomTypeService.save(roomType);
    }

    @PostMapping("/delete/room-type")
    public void deleteRoomType(){

    }


}
