package com.hotel.HotelManagement.controller.User;

import com.hotel.HotelManagement.dto.request.CustomerTypeQueryRequest;
import com.hotel.HotelManagement.dto.request.RoomQueryRequest;
import com.hotel.HotelManagement.entity.*;
import com.hotel.HotelManagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.util.List;

@Controller
public class UserOwnerController {
    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RegulationService regulationService;

    @Autowired
    private RevenueReportService revenueReportService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/get-all/room-type")
    public List<RoomType> getRoomTypes() {
        return roomTypeService.getAllRoomTypes();
    }

    @GetMapping("/query/room-type")
    public List<RoomType> queryRoomTypes(@RequestBody String query) {
        return roomTypeService.findRoomTypesByName(query);
    }

    @PostMapping("/save/room-type")
    public RoomType createOrUpdateRoomType(@RequestBody RoomType roomType) {
        return roomTypeService.save(roomType);
    }

    @PostMapping("/delete/room-type")
    public void deleteRoomType(@RequestBody RoomType roomType) {
        roomTypeService.delete(roomType);
    }

    @GetMapping("/get-all/room")
    public List<Room> getRooms() {
        return roomService.getRooms();
    }

    @GetMapping("/query/room")
    public List<Room> queryRooms(@RequestBody RoomQueryRequest query) {
        if (query == null) {
            return null;
        }

        int roomId = query.getRoomId();
        if (roomId >= 0) {
            return roomService.getRoomsById(roomId);
        }

        String roomTypeName = query.getRoomTypeName();
        if (roomTypeName != null) {
            RoomType type = roomTypeService.findRoomTypeByName(roomTypeName);
            return roomService.getRoomsByRoomType(type);
        }

        String roomStatusString = query.getRoomStatusString();
        if (roomStatusString != null) {
            Room.Status status = Room.Status.valueOf(roomStatusString);
            return roomService.getRoomsByStatus(status);
        }

        return null;
    }

    @PostMapping("/save/room")
    public Room createOrUpdateRoom(@RequestBody Room room) {
        return roomService.save(room);
    }

    @PostMapping("/delete/room")
    public void deleteRoom(@RequestBody Room room) {
        roomService.delete(room);
    }

    @PostMapping("/save/regulation")
    public Regulation updateRegulation(@RequestBody Regulation regulation) {
        return regulationService.saveRegulation(regulation);
    }

    @GetMapping("/get/revenue-report")
    public RevenueReport getRevenueReport(@RequestBody Date date) {
        return revenueReportService.getRevenueReportByMonth(date);
    }

    @PostMapping("/save/revenue-report")
    public RevenueReport saveRevenueReport(@RequestBody RevenueReport revenueReport) {
        revenueReportService.addRevenueReport(revenueReport);
        return revenueReport;
    }

    @GetMapping("/get/customer-type")
    public List<CustomerType> getCustomerTypes() {
        return customerTypeService.getAllCustomerTypes();
    }

    @GetMapping("/query/customer-type")
    public List<CustomerType> queryCustomerTypes(@RequestBody CustomerTypeQueryRequest customerTypeQueryRequest) {
        if (customerTypeQueryRequest == null) {
            return null;
        }

        String customerTypeId = customerTypeQueryRequest.getCustomerTypeId();
        if (customerTypeId != null) {
            return List.of(customerTypeService.findCustomerTypeById(customerTypeId));
        }

        String customerTypeName = customerTypeQueryRequest.getCustomerTypeName();
        if (customerTypeName != null) {
            return customerTypeService.findCustomerTypesByName(customerTypeName);
        }

        return null;
    }

    @PostMapping("/save/customer-type")
    public CustomerType createOrUpdateCustomerType(@RequestBody CustomerType customerType) {
        customerTypeService.save(customerType);
        return customerType;
    }

    @PostMapping("/delete/customer-type")
    public void deleteCustomerType(@RequestBody CustomerType customerType) {
        customerTypeService.delete(customerType);
    }
}
