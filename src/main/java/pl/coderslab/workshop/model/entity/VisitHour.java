package pl.coderslab.workshop.model.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "visit_hour")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VisitHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalTime hour;
//    Uznajmy że to Boolean
    @ManyToOne
    private ClientVisit clientVisit;
}
