package pl.coderslab.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.workshop.model.entity.ClientVisit;

@Repository
public interface ClientVisitRepository extends JpaRepository <ClientVisit,Long> {

//    Optional<List<ClientVisit>> findAllBy(String username);



}
