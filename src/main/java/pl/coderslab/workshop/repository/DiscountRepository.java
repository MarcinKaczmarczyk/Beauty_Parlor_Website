package pl.coderslab.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.workshop.model.entity.Discount;

import java.util.Optional;

//TODO Nie oznaczamy tymi adnotacjami interfejsów
@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {

   Optional<Discount> getByName (String name);

   Discount getFirstById(Long id);
}
