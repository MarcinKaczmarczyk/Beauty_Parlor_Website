package pl.coderslab.workshop.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "password")
public class Admin {

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

    @Pattern(regexp = "^\\d{9}$", message = "Niepoprawny numer telefonu")
    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;


}
