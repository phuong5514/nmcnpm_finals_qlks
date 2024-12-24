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

    @GetMapping("/regulation")
    public String regulation(Model model) {
        Regulation regulation = regulationService.getRegulation();
        model.addAttribute("regulation", regulation);
        return "regulation";
    }

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

    @PostMapping("/rooms/update-status")
    public Room updateRoomStatus(@Valid @RequestBody RoomStatusUpdateRequest roomStatusUpdateRequest) {
        Room room = roomService.getRoom(roomStatusUpdateRequest.getRoomId());
        if (room != null) {
            return null;
        }

        Room.Status status = Room.Status.valueOf(roomStatusUpdateRequest.getRoomStatusString());
        if (status != null) {
            room.setStatus(status);
        } else {
            return null;
        }
        return room;
    }

    @PostMapping("/rental-voucher/create")
    public RentalVoucher createRentalVoucher(@Valid @RequestBody RentalVoucherCreationRequest rentalVoucherCreationRequest) {
        RentalVoucher rentalVoucher = new RentalVoucher();
        rentalVoucher.setRoomId(rentalVoucherCreationRequest.getRoomId());
        rentalVoucher.setCustomerId(rentalVoucherCreationRequest.getCustomerId());
        rentalVoucher.setStartDate(rentalVoucherCreationRequest.getStartDate());

        return rentalVoucherService.save(rentalVoucher);
    }

    @PostMapping("/rental-vouchers/update")
    public RentalVoucher updateRentalVoucher(@Valid @RequestBody RentalVoucherModificationRequest rentalVoucherDTO) {
        RentalVoucher rentalVoucher = rentalVoucherService.getRentalVoucher(rentalVoucherDTO.getVoucherId());

        if (rentalVoucher == null) {
            return null;
        }

        rentalVoucher.setStartDate(rentalVoucherDTO.getStartDate());
        rentalVoucher.setCustomerId(rentalVoucherDTO.getCustomerId());
        rentalVoucher.setRoomId(rentalVoucherDTO.getRoomId());

        return rentalVoucherService.save(rentalVoucher);
    }

    @PostMapping("/rental-vouchers/update-status")
    public RentalVoucher updateRentalVoucherStatus(@Valid @RequestBody RentalVoucherStatusUpdateRequest rentalVoucherDTO) {
        RentalVoucher rentalVoucher = rentalVoucherService.getRentalVoucher(rentalVoucherDTO.getVoucherId());
        if (rentalVoucher == null) {
            return null;
        }

        RentalVoucher.Status status = RentalVoucher.Status.valueOf(rentalVoucherDTO.getStatusString());
        if (status == null) {
            return null;
        }

        rentalVoucher.setStatus(status);
        return rentalVoucherService.save(rentalVoucher);
    }

    @PostMapping("/rental-vouchers/delete")
    public void deleteRentalVoucher(@Valid @RequestBody RentalVoucherDeletionRequest rentalVoucherDTO) {
        rentalVoucherService.delete(rentalVoucherDTO.getRentalVoucherId());
    }


    @PostMapping("/invoices/create")
    public Invoice createInvoice(@Valid @RequestBody InvoiceCreationRequest invoiceCreationRequest) {
        Invoice invoice = new Invoice();
        invoice.setCustomerId(invoiceCreationRequest.getCustomerId());
        invoice.setIssuedDate(invoiceCreationRequest.getIssuedDate());
        invoice.setTotalAmount(invoiceCreationRequest.getTotalAmount());

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

    @PostMapping("/customers/create")
    public Customer createCustomer(@Valid @RequestBody CustomerCreationRequest customerCreationRequest) {
        String typeId = customerCreationRequest.getCutomerTypeString();
        CustomerType type = customerTypeService.findCustomerTypeById(typeId);
        if (type == null) {
            return null;
        }

        String identityCard = customerCreationRequest.getIdentityCard();
        Customer checkedCustomer = customerService.findCustomerByIdCard(identityCard.trim());
        if (checkedCustomer != null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setCustomerName(customerCreationRequest.getCustomerName());
        customer.setAddress(customerCreationRequest.getAddress());
        customer.setIdentityCard(customerCreationRequest.getIdentityCard());
        customer.setCustomerTypeID(typeId);
        return customerService.save(customer);
    }


    @PostMapping("/customers/save")
    public Customer updateCustomer(@Valid @RequestBody CustomerModificationRequest customerDTO) {
        Customer customer = customerService.findCustomerById(customerDTO.getCustomerId());

        if (customer == null) {
            return null;
        }

        String typeId = customerDTO.getCutomerTypeString();
        CustomerType type = customerTypeService.findCustomerTypeById(typeId);
        if (type == null) {
            return null;
        }

        // khong cho 2 khach hang co cung giay cmnd
        String identityCard = customerDTO.getIdentityCard();
        Customer checkedCustomer = customerService.findCustomerByIdCard(identityCard.trim());
        if (checkedCustomer.getCustomerId() != customer.getCustomerId()) {
            return null;
        }

        customer.setCustomerTypeID(typeId);
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setAddress(customerDTO.getAddress());
        customer.setIdentityCard(customerDTO.getIdentityCard());

        return customerService.save(customer);
    }
}
