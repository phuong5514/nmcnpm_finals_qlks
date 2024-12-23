package com.hotel.HotelManagement.controller.User;

import com.hotel.HotelManagement.dto.request.CustomerCreationOrUpdateRequest;
import com.hotel.HotelManagement.dto.request.InvoiceCreationOrUpdateRequest;
import com.hotel.HotelManagement.dto.request.RentalVoucherCreationOrUpdateRequest;
import com.hotel.HotelManagement.dto.request.RentalVoucherDeletionRequest;
import com.hotel.HotelManagement.entity.*;
import com.hotel.HotelManagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
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
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/rooms")
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


    @PostMapping("/rental-vouchers/save")
    public RentalVoucher createOrUpdateRentalVoucher(@RequestBody RentalVoucherCreationOrUpdateRequest rentalVoucherDTO) {
        RentalVoucher rentalVoucher = new RentalVoucher();
        int rentalVoucherId = rentalVoucherDTO.getVoucherId();
        if (rentalVoucherId > 0) {
            rentalVoucher.setVoucherId(rentalVoucherId);
        }

        Room room = roomService.getRoomById(rentalVoucherDTO.getRoomId());
        if (room == null) {
            return null;
        }
        rentalVoucher.setRoom(room);

        Customer customer = customerService.findCustomerById(rentalVoucherDTO.getCustomerId());
        if (customer == null) {
            return null;
        }
        rentalVoucher.setCustomer(customer);

        rentalVoucher.setStartDate(rentalVoucherDTO.getStartDate());

        RentalVoucher.Status status = RentalVoucher.Status.valueOf(rentalVoucherDTO.getStatusString());
        rentalVoucher.setStatus(status);

        return rentalVoucherService.save(rentalVoucher);
    }

    @PostMapping("/rental-vouchers/delete")
    public void deleteRentalVoucher(@RequestBody RentalVoucherDeletionRequest rentalVoucherDTO) {
        rentalVoucherService.delete(rentalVoucherDTO.getRentalVoucherId());
    }

    @PostMapping("/invoices/save")
    public Invoice createOrUpdateInvoice(@RequestBody InvoiceCreationOrUpdateRequest invoiceDTO) {
        Invoice invoice = new Invoice();
        if (invoiceDTO.getInvoiceId() > 0) {
            invoice.setInvoiceId(invoiceDTO.getInvoiceId());
        }

        Customer customer = customerService.findCustomerById(invoiceDTO.getCustomerId());
        if (customer == null) {
            return null;
        }
        invoice.setCustomer(customer);

        invoice.setIssuedDate(invoiceDTO.getIssuedDate());
        invoice.setTotalAmount(invoiceDTO.getTotalAmount());

        return invoiceService.save(invoice);
    }

    @GetMapping("/customers")
    public String getCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "customerList";
    }

    @GetMapping("/customers/query")
    public String queryCustomers(@RequestParam(required = false) String name, @RequestParam(required = false) String idCard, Model model) {
        List<Customer> customers = Collections.emptyList();
        if (name != null) {
            customers = customerService.findCustomerByName(name.trim());
        }

        if (idCard != null) {
            Customer customer = customerService.findCustomerByIdCard(idCard.trim());
            if (customer == null) {
                return null;
            }
            customers.add(customer);
        }

        model.addAttribute("customers", customers);
        return "customerList";
    }

    @PostMapping("/customers/save")
    public Customer createOrUpdateCustomer(@RequestBody CustomerCreationOrUpdateRequest customerDTO) {
        Customer customer = new Customer();

        int customerId = customerDTO.getCustomerId();
        if (customerId > 0) {
            customer.setCustomerId(customerId);
        }

        customer.setCustomerName(customerDTO.getCustomerName());

        Customer customerByIdCard = customerService.findCustomerByIdCard(customerDTO.getIdentityCard());
        if (customerByIdCard == null || customerByIdCard.getCustomerId() == customerId) {
            customer.setIdentityCard(customerDTO.getIdentityCard());
        } else {
            return null;
        }

        customer.setAddress(customerDTO.getAddress());

        CustomerType type = customerTypeService.findCustomerTypeById(customerDTO.getCutomerTypeString());
        if (type == null) {
            return null;
        }
        customer.setCutomerType(type);

        return customerService.save(customer);
    }
}
