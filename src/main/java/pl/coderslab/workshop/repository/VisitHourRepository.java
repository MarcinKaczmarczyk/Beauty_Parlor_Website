package pl.coderslab.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.workshop.model.entity.VisitHour;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface VisitHourRepository extends JpaRepository <VisitHour,Long> {

    @Query("SELECT vh.hour FROM VisitDay v JOIN v.visitHours vh JOIN v.employee e WHERE v.visitDate=?1 AND vh.clientVisit IS NULL AND e.userName=?2")
    List<LocalTime> findAllHoursByVisitDateAndEmployee(LocalDate date,String username);
}
