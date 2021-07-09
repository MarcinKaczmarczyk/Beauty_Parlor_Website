package pl.coderslab.workshop.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.workshop.model.entity.Employee;
import pl.coderslab.workshop.model.entity.VisitDay;
import pl.coderslab.workshop.model.entity.VisitHour;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VisitDayRepository extends JpaRepository<VisitDay,Long> {

    @Query("SELECT v.visitHours FROM VisitDay v WHERE v=?1")
    List<VisitHour>getFirstByVisitDay(VisitDay visitDay);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD,
            attributePaths = { "visitHours" })
    VisitDay getFirstByEmployeeAndVisitDate(Employee employee, LocalDate visitDate);

    @Query("SELECT v FROM VisitDay v ORDER BY v.visitDate DESC ")
    List<VisitDay> getAllByVisitDate();

    List<VisitDay> findAllByEmployeeUserName(String username);

//    VisitDay getFirstByServiceCategoryOrderByVisitDateDesc(ServiceCategory category);

//        @Query("SELECT new pl.coderslab.workshop.model.dto.VisitDayMapDto(v.visitDate,) FROM VisitDay v JOIN v.employee e JOIN v.visitHours vh WHERE e.userName=?1")
//       List<VisitDayMapDto> findAllToMapByEmployeeUserName(String username);

//    pl.coderslab.workshop.model.dto

//    @Query("SELECT new pl.coderslab.workshop.model.dto.VisitDayMapTest(v.visitDate, vh.hour) FROM VisitDay v JOIN v.employee e JOIN v.visitHours vh WHERE e.userName=?1")
//   VisitDayMapTest findAllToMapaByEmployeeUserName(String username);

//    @Query("SELECT vh.hour FROM VisitDay v JOIN v.visitHours vh WHERE v.visitDate=?1 AND vh.clientVisit IS NULL")
//    List<LocalTime> findAllByVisitDate(LocalDate date);


@Query("SELECT v.visitDate FROM VisitDay v JOIN v.employee e WHERE e.userName=?1 ORDER BY v.visitDate")
    List<LocalDate> findAllDateByEmployeeUserName(String username);
}
