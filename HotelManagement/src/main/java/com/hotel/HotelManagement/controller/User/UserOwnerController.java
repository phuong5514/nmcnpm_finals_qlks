package com.hotel.HotelManagement.controller.User;

import com.hotel.HotelManagement.dto.request.*;
import com.hotel.HotelManagement.entity.*;
import com.hotel.HotelManagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Collections;
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

    @GetMapping("/room-types")
    public String getRoomType(Model model) {
        List<RoomType> roomTypes = roomTypeService.getAllRoomTypes();
        model.addAttribute("roomTypes", roomTypes);
        return "roomTypeList";
    }

    @GetMapping("/room-types/query")
    public String queryRoomType(@RequestParam String name, Model model) {
        List<RoomType> roomTypes = roomTypeService.findRoomTypesByName(name);
        model.addAttribute("roomTypes", roomTypes);
        return "roomTypeList";
    }

    @PostMapping("/room-types/save")
    public RoomType createOrUpdateRoomType(@RequestBody RoomTypeCreationOrUpdateRequest roomTypeDTO) {
        RoomType roomType = new RoomType();
        if (roomType.getRoomTypeName() != null) {
            roomType.setRoomTypeName(roomType.getRoomTypeName());
        }
        roomType.setBasePrice(roomTypeDTO.getBasePrice());

        return roomTypeService.save(roomType);
    }


    @PostMapping("/room-types/delete")
    public void deleteRoomType(@RequestBody RoomTypeDeletionRequest roomTypeDTO) {
        RoomType roomType = roomTypeService.findRoomTypeByName(roomTypeDTO.getRoomTypeName());
        if (roomType != null) {
            roomTypeService.delete(roomType);
        } else {
            throw new IllegalArgumentException("room type not found");
        }
    }

    @GetMapping("rooms")
    public String getRoom(Model model) {
        List<Room> rooms = roomService.getRooms();
        model.addAttribute("rooms", rooms);
        return "roomList";
    }

    @GetMapping("/rooms/query")
    public String queryRoom(
            @RequestParam(required = false) String roomTypeName,
            @RequestParam(required = false) String roomStatusString,
            Model model) {

        List<Room> rooms = Collections.emptyList();
        if (roomTypeName != null) {
            RoomType roomType = roomTypeService.findRoomTypeByName(roomTypeName);
            rooms = roomService.getRoomsByRoomType(roomType);
        }

        if (roomStatusString != null) {
            Room.Status status = Room.Status.valueOf(roomStatusString);
            rooms = roomService.getRoomsByStatus(status);
        }



        model.addAttribute("rooms", rooms);

        return "roomList";
    }

    @PostMapping("/rooms/add")
    public Room addRoom(@RequestBody RoomCreationRequest roomDTO) {
        Room room = new Room();
        RoomType roomType = roomTypeService.findRoomTypeByName(roomDTO.getRoomTypeString());
        room.setRoomType(roomType);

        return roomService.save(room);
    }

    @PostMapping("/rooms/update")
    public Room updateRoom(@RequestBody RoomUpdateRequest roomDTO) {
        RoomType roomType = roomTypeService.findRoomTypeByName(roomDTO.getRoomTypeString());
        Room.Status status = Room.Status.valueOf(roomDTO.getRoomStatusString());
        Room room = new Room(roomDTO.getRoomId(), status, roomType);

        return roomService.save(room);
    }

    @PostMapping("/rooms/delete")
    public void deleteRoom(@RequestBody RoomDeletionRequest roomDTO) {
        roomService.getRoomById(roomDTO.getRoomId());
    }

    @GetMapping("/regulation")
    public String getRegulation(Model model) {
        Regulation regulation = regulationService.getRegulation();
        model.addAttribute("regulation", regulation);
        return "regulation";
    }

    @PostMapping("/regulation/save")
    public Regulation updateRegulation(@RequestBody RegulationUpdateRequest regulationDTO) {
        Regulation regulation = regulationService.getRegulation();

        int maxGuestCount = regulationDTO.getDefaultMaxGuestCount();
        if (maxGuestCount > 0) {
            regulation.setDefaultMaxGuestCount(maxGuestCount);
        }

        double overGuestRate = regulationDTO.getDefaultOverGuestRate();
        if (overGuestRate >= 0.0) {
            regulation.setDefaultOverGuestRate(overGuestRate);
        }

        return regulationService.saveRegulation(regulation);
    }

    @GetMapping("/revenue-reports")
    public RevenueReport getRevenueReport(@RequestParam Date date) {
        return revenueReportService.getRevenueReportByMonth(date);
    }

    @PostMapping("/revenue-reports/save")
    public RevenueReport saveRevenueReport(@RequestBody RevenueReportCreationOrUpdateRequest revenueReportDTO) {
        RevenueReport revenueReport = new RevenueReport();

        int revenueReportId = revenueReportDTO.getRevenueReportID();
        if (revenueReportId > 0) {
            revenueReport.setRevenueReportID(revenueReportId);
        }

        revenueReport.setRevenue(revenueReportDTO.getRevenue());
        revenueReport.setMonth(revenueReportDTO.getMonth());
        revenueReport.setRoomType(revenueReportDTO.getRoomType());
        revenueReport.setPercentage(revenueReportDTO.getPercentage());

        return revenueReportService.save(revenueReport);
    }

    @GetMapping("/customer-types")
    public String getCustomerType(Model model) {
        List<CustomerType> customerTypes = customerTypeService.getAllCustomerTypes();
        model.addAttribute("customerTypes", customerTypes);
        return "customerTypeList";
    }

    @GetMapping("/customer-types/query")
    public String queryCustomerTypes(@RequestParam String customerTypeName, Model model) {
        List<CustomerType> customerTypes = customerTypeService.findCustomerTypesByName(customerTypeName);
        model.addAttribute("customerTypes", customerTypes);
        return "customerTypeList";
    }

    @PostMapping("/customer-types/save")
    public CustomerType createOrUpdateCustomerType(@RequestBody CustomerTypeCreationOrUpdateRequest customerTypeDTO) {
        CustomerType customerType = new CustomerType();
        String customerTypeID = customerTypeDTO.getCustomerTypeID();
        if (customerTypeID != null) {
            customerType.setCustomerTypeID(customerTypeID);
        }
        customerType.setCustomerTypeName(customerTypeDTO.getCustomerTypeName());
        customerType.setFeeModifier(customerTypeDTO.getFeeModifier());
        return customerTypeService.save(customerType);
    }

    @PostMapping("/customer-types/delete")
    public void deleteCustomerType(@RequestBody CustomerTypeDeletionRequest customerTypeDTO) {
        customerTypeService.delete(customerTypeDTO.getCustomerTypeID());
    }
}
