package pl.coderslab.workshop.model.entity;

import lombok.*;
import pl.coderslab.workshop.model.ServiceCategory;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"password","login"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String userName;

    @Column(nullable = false, unique = true, length = 100)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private ServiceCategory serviceCategory;

    @ManyToMany
    private Set<WorkHour> workHour=new HashSet<>();

    @ManyToMany
    private Set<VisitDay> visitDay=new HashSet<>();

    @ManyToMany
    @JoinTable(name = "employee_service",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<Service> services = new HashSet<>();

}
