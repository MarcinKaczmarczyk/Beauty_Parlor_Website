package pl.coderslab.workshop.model.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "work_hour")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkHour {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_work",nullable = false)
    private LocalTime startWork;
    @Column(name = "end_work",nullable = false)
    private LocalTime endWork;
    @Column(name = "day_work",nullable = false)
    private LocalDate dayWork;

}
