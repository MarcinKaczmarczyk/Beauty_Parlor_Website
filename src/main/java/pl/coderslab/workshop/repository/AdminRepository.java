package pl.coderslab.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.workshop.model.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository <Admin,Long> {
}
