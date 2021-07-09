package pl.coderslab.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.workshop.model.entity.OpeningHour;

@Repository
public interface OpeningHourRepository extends JpaRepository <OpeningHour,Long> {

}
