package pl.coderslab.workshop.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"password", "login"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false, unique = true, length = 30)
    private String userName;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;


    @Column(nullable = false, name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToMany()
    private Set<ClientVisit> clientVisits = new HashSet<>();

    @ManyToMany()
    @JoinTable(name = "user_discount",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "discount_id")
    )
    private Set<Discount> discounts=new HashSet<>();

    private Integer visits;

}
