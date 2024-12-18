package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query("SELECT i FROM Invoice i WHERE MONTH(i.IssuedDate) = :month AND YEAR(i.IssuedDate) = :year")
    List<Invoice> findInvoicesInMonth(@Param("month") int month, @Param("year") int year);

    @Query("select i From Invoice i where year(i.IssuedDate) = :year")
    List<Invoice> findInvoicesInYear(@Param("year") int year);
}
