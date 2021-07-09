package pl.coderslab.workshop.model.entity;


import lombok.*;
import pl.coderslab.workshop.model.ServiceCategory;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "client_visit")
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private ServiceCategory category;

    @ManyToOne
    private VisitDay visitDays;

    @OneToMany
    private List<VisitHour> visitHours;

    @OneToOne
    private Service service;

    @OneToOne
    private Employee employee;


    public ClientVisit(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }
}
