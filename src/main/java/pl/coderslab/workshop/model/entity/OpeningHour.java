package pl.coderslab.workshop.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OpeningHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private DayOfWeek dayOfWeek;

    @Column(name = "open_hours")
    private LocalTime open;

    @Column(name = "close_hours")
    private LocalTime close;


}
