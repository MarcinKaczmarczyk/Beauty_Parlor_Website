package pl.coderslab.workshop.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "services")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    @Column(name = "percent_discount")
    private Double percentPromotion;

    @Column(name = "value_discount")
    private Integer amountPromotion;

    @ManyToMany
    private Set<Service>services= new HashSet<>();

    public Discount(String name,String description, Integer amountPromotion, Set<Service> service) {
        this.name = name;
        this.description = description;
        this.amountPromotion = amountPromotion;
        this.services = service;
    }

    public Discount(String name,String description, Double percentPromotion, Set<Service> service) {
        this.name = name;
        this.description = description;
        this.percentPromotion = percentPromotion;
        this.services = service;
    }
}
