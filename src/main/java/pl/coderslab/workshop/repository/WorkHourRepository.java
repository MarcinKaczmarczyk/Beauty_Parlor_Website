package pl.coderslab.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.workshop.model.entity.WorkHour;

@Repository
public interface WorkHourRepository extends JpaRepository<WorkHour,Long> {
}
