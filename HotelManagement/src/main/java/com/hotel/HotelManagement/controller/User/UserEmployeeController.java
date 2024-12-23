package com.hotel.HotelManagement.controller.User;

import com.hotel.HotelManagement.dto.request.RoomQueryRequest;
import com.hotel.HotelManagement.entity.*;
import com.hotel.HotelManagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserEmployeeController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private RentalVoucherService rentalVoucherService;

    @Autowired
    private RegulationService regulationService;

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

    @PostMapping("/save/rental-voucher")
    public RentalVoucher createOrUpdateRentalVoucher(@RequestBody RentalVoucher rentalVoucher) {
        if (rentalVoucher == null) {
            return null;
        }

        return rentalVoucherService.save(rentalVoucher);
    }

    @PostMapping("/save/invoice")
    public Invoice createOrUpdateInvoice(@RequestBody Invoice invoice) {
        if (invoiceService == null) {
            return null;
        }
        return invoiceService.save(invoice);
    }

    @PostMapping("/save/customer")
    public Customer createOrUpdateCustomer(@RequestBody Customer customer) {
        if (customerService == null) {
            return null;
        }
        return customerService.save(customer);
    }

    @GetMapping("/get/customer")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
}
