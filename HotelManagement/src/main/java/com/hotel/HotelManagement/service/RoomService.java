package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.Room;
import com.hotel.HotelManagement.entity.RoomType;
import com.hotel.HotelManagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> getRoomsByStatus(Room.Status status) {
        return roomRepository.findRoomsByRoomStatus(status.toString());
    }

    @Override
    public List<Room> getRoomsByRoomType(RoomType roomType) {
        return roomRepository.getRoomsByRoomType(roomType);
    }

    @Override
    public List<Room> getRoomsById(Integer id) {
        return roomRepository.findRoomsByRoomIdContaining(id);
    }

    @Override
    public Room getRoom(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void delete(Room room) {
        roomRepository.delete(room);
    }
}
