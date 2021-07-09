package pl.coderslab.workshop.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "visit_day")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "employee")
public class VisitDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employee;

    @Column(nullable = false,name = "visit_date")
    private LocalDate visitDate;

    @OneToMany
    List<VisitHour>visitHours=new ArrayList<>();


}
