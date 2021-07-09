package pl.coderslab.workshop.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.workshop.model.dto.BookingVisitDto;
import pl.coderslab.workshop.model.entity.ClientVisit;
import pl.coderslab.workshop.model.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByUserName(String userName);


    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD,
            attributePaths = { "clientVisits","discounts" })
    User findAllWithVisitsByUserName(String username);

    @Query("SELECT u.clientVisits FROM User u WHERE u.userName LIKE ?1")
    Optional<List<ClientVisit>>clientVisitList(String name);

    @Query("SELECT new pl.coderslab.workshop.model.entity.ClientVisit(u.name, u.surname, u.phoneNumber) FROM User u WHERE u.userName=?1")
    ClientVisit fillInClientVisitByUsername(String userName);



}
