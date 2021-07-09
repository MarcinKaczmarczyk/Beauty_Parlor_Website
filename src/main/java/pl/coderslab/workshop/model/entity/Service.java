package pl.coderslab.workshop.model.entity;

import lombok.*;
import pl.coderslab.workshop.model.ServiceCategory;

import javax.persistence.*;
import java.time.LocalTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "service")
@ToString()
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(nullable = false, length = 2000)
    private String description;

    @Column(nullable = false)
    private LocalTime executionTime;

    @Column(nullable = false, precision = 4)
    private Integer price;

    @Column(nullable = false)
    private ServiceCategory serviceCategory;

//    @ManyToMany
//    private Set<Employee> employees = new HashSet<>();
}
