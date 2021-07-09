package pl.coderslab.workshop.model.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import pl.coderslab.workshop.model.entity.Discount;
import pl.coderslab.workshop.model.ServiceCategory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
@NoArgsConstructor
public class BookingVisitDto {

    private String name;

    private String surname;

    private String phoneNumber;

    private ServiceCategory category;

    private LocalDate visitDay;

    private LocalTime visitHours;

    private String serviceName;

    private Integer price;

    private String employeeUserName;

    private String employeeName;

    private LocalTime serviceTime;

    private Set<Discount> discounts;


    public BookingVisitDto(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }
}
