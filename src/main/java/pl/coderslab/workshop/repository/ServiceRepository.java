package pl.coderslab.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.workshop.model.entity.Service;
import pl.coderslab.workshop.model.ServiceCategory;

import java.time.LocalTime;
import java.util.Set;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {

Set<Service> findAllByServiceCategory(ServiceCategory category);

    Service findByName(String name);

    @Query("SELECT s.executionTime FROM Service s WHERE s.name=?1")
    LocalTime getFirstTimeByName(String name);

//    @Query("SELECT s.")
//    List<ServiceListDto> getServiceByServiceCategory(ServiceCategory category);



}
