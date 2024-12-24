package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.UsageReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface UsageReportRepository extends JpaRepository<UsageReport, String> {
    UsageReport getUsageReportByUsageReportID(int usageReportID);

    @Query("Select i from UsageReport i where MONTH(i.month) = MONTH(:_month) AND YEAR(i.month) = YEAR(:_month)")
    List<UsageReport> findUsageReportsByMonth(@Param("_month") Date month);

    @Query("Select i from UsageReport i where MONTH(i.month) = MONTH(:_month) AND YEAR(i.month) = YEAR(:_month) AND i.roomID = :room")
    UsageReport findUsageReportsByMonthAndRoomID(@Param("_month") Date month, @Param("room") int roomID);
}
