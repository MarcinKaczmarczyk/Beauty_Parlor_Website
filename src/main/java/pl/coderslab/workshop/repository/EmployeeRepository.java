package pl.coderslab.workshop.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.workshop.model.dto.EmployeeFullNameDto;
import pl.coderslab.workshop.model.entity.Employee;
import pl.coderslab.workshop.model.entity.Service;
import pl.coderslab.workshop.model.ServiceCategory;

import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.serviceCategory=?1")
    Set<Employee> findAllByServiceCategory(ServiceCategory category);


    Set<Employee> findAllByServices(Service service);

    Employee getFirstById(Long id);

    Employee getFirstByUserName(String username);

    @Query("SELECT e FROM Employee e JOIN e.services s WHERE s.name=?1")
    Set<Employee> findAllByServicesName(String service);


    @Query("SELECT new pl.coderslab.workshop.model.dto.EmployeeFullNameDto(e.name,e.surname) FROM Employee e WHERE e.userName=?1")
    EmployeeFullNameDto findFullNameByUserName(String username);


    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD,
            attributePaths = { "workHour","visitDay" })
    Set<Employee> findAllWithWorkHourAndVisitDayBy();
/*new pl.coderslab.workshop.model.dto.EmployeeClosestTimeDto(e.name,e.surname,e.visitDay,v.visitHours)*/
@EntityGraph(type = EntityGraph.EntityGraphType.LOAD,
        attributePaths = { "visitDay" })
/*SELECT e FROM Employee e JOIN e.visitDay v JOIN v.visitHours vh WHERE e.serviceCategory=?1 AND vh.hour IS NULL ORDER BY v.visitDate*/
    @Query("SELECT e FROM Employee e JOIN e.visitDay v WHERE e.serviceCategory=?1 ORDER BY v.visitDate")
        List<Employee> findAllEmployeeWithClosestTerm(ServiceCategory category);

}
