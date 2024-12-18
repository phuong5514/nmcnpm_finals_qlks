package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.Room;
import com.hotel.HotelManagement.entity.RoomType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRoomService {
    List<Room> getRooms();
    List<Room> getRoomsByStatus(Room.Status status);
    List<Room> getRoomsByRoomType(RoomType roomType);
    List<Room> getRoomsById(Integer id);

    Room getRoom(Integer id);
    Room save(Room room);
    void delete(Room room);
}
