package com.hotel.HotelManagement.controller.User;

import com.hotel.HotelManagement.dto.request.*;
import com.hotel.HotelManagement.entity.*;
import com.hotel.HotelManagement.service.*;
import jakarta.validation.Valid;
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

    @PostMapping("/room-types/create")
    public RoomType addRoomType(@Valid @RequestBody RoomTypeCreationRequest roomTypeDTO) {
        RoomType roomType = new RoomType();
        roomType.setRoomTypeName(roomTypeDTO.getRoomTypeName());
        roomType.setBasePrice(roomTypeDTO.getBasePrice());

        Double overGuestRate = roomTypeDTO.getOverGuestRate();
        if (overGuestRate != null) {
            roomType.setOverGuestRate(overGuestRate);
        } else {
            Regulation regulation = regulationService.getRegulation();
            roomType.setOverGuestRate(regulation.getDefaultOverGuestRate());
        }
        return roomTypeService.save(roomType);
    }

    @PostMapping("/room-types/update")
    public RoomType updateRoomType(@Valid @RequestBody RoomTypeModificationRequest roomTypeDTO) {
        RoomType roomType = roomTypeService.findRoomTypeByName(roomTypeDTO.getRoomTypeName());

        if (roomType == null) {
            throw new IllegalArgumentException("Room type not found");
        }

        roomType.setBasePrice(roomTypeDTO.getBasePrice());
        roomType.setOverGuestRate(roomTypeDTO.getOverGuestRate());

        return roomTypeService.save(roomType);
    }


    @PostMapping("/room-types/delete")
    public void deleteRoomType(@Valid @RequestBody RoomTypeDeletionRequest roomTypeDTO) {
        RoomType roomType = roomTypeService.findRoomTypeByName(roomTypeDTO.getRoomTypeName());
        roomTypeService.delete(roomType);
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

    @PostMapping("/rooms/create")
    public Room addRoom(@Valid @RequestBody RoomCreationRequest roomDTO) {
        Room room = new Room();

        room.setRoomTypeName(roomDTO.getRoomTypeString());

        Integer maxGuestCount = roomDTO.getMaxGuestCount();
        if (maxGuestCount != null) {
            room.setMaxGuestCount(maxGuestCount);
        } else {
            Regulation regulation = regulationService.getRegulation();
            room.setMaxGuestCount(regulation.getDefaultMaxGuestCount());
        }

        return roomService.save(room);
    }

    @PostMapping("/rooms/update")
    public Room updateRoom(@Valid @RequestBody RoomModificationRequest roomDTO) {
        Room room = roomService.getRoomById(roomDTO.getRoomId());
        if (room == null) {
            throw new IllegalArgumentException("Room not found");
        }

        room.setRoomTypeName(roomDTO.getRoomTypeString());
        room.setMaxGuestCount(roomDTO.getMaxGuestCount());
        room.setRoomTypeName(roomDTO.getRoomTypeString());

        return roomService.save(room);
    }

    @PostMapping("/rooms/delete")
    public void deleteRoom( @Valid @RequestBody RoomDeletionRequest roomDTO) {
        roomService.getRoomById(roomDTO.getRoomId());
    }

    @GetMapping("/regulation")
    public String getRegulation(Model model) {
        Regulation regulation = regulationService.getRegulation();
        model.addAttribute("regulation", regulation);
        return "regulation";
    }

    @PostMapping("/regulation/save")
    public Regulation updateRegulation(@Valid @RequestBody RegulationModificationRequest regulationDTO) {
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

    @PostMapping("/revenue-reports/create")
    public RevenueReport addRevenueReport(@Valid @RequestBody RevenueReportCreationRequest revenueReportDTO) {
        RevenueReport revenueReport = new RevenueReport();
        revenueReport.setRoomTypeName(revenueReportDTO.getRoomTypeName());
        revenueReport.setMonth(revenueReportDTO.getMonth());
        revenueReport.setRevenue(revenueReportDTO.getRevenue());
        revenueReport.setPercentage(revenueReportDTO.getPercentage());
        return revenueReportService.save(revenueReport);
    }

    @PostMapping("/revenue-reports/update")
    public RevenueReport saveRevenueReport(@Valid @RequestBody RevenueReportModificationRequest revenueReportDTO) {
        RevenueReport revenueReport = revenueReportService.getRevenueReportById(revenueReportDTO.getRevenueReportID());

        if (revenueReport == null) {
            throw new IllegalArgumentException("RevenueReport not found");
        }

        revenueReport.setRevenue(revenueReportDTO.getRevenue());
        revenueReport.setMonth(revenueReportDTO.getMonth());
        revenueReport.setRoomTypeName(revenueReportDTO.getRoomTypeName());
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

    @PostMapping("/customer-types/create")
    public CustomerType createCustomerType(@Valid @RequestBody CustomerTypeCreationRequest customerTypeCreationRequest) {
        CustomerType customerType = new CustomerType();
        customerType.setFeeModifier(customerTypeCreationRequest.getFeeModifier());
        customerType.setCustomerTypeName(customerTypeCreationRequest.getCustomerTypeName());
        return customerTypeService.save(customerType);
    }

    @PostMapping("/customer-types/update")
    public CustomerType updateCustomerType(@Valid @RequestBody CustomerTypeModificationRequest customerTypeDTO) {
        CustomerType customerType = customerTypeService.findCustomerTypeById(customerTypeDTO.getCustomerTypeID());

        if (customerType == null) {
            throw new IllegalArgumentException("CustomerType not found");
        }

        customerType.setCustomerTypeName(customerTypeDTO.getCustomerTypeName());
        customerType.setFeeModifier(customerTypeDTO.getFeeModifier());
        return customerTypeService.save(customerType);
    }

    @PostMapping("/customer-types/delete")
    public void deleteCustomerType(@Valid @RequestBody CustomerTypeDeletionRequest customerTypeDTO) {
        customerTypeService.delete(customerTypeDTO.getCustomerTypeID());
    }
}
