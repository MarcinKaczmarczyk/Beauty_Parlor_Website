package pl.coderslab.workshop.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservationConfirmationDto {


    private String employeeName;

    private String serviceName;

    private LocalTime visitTime;

    private LocalDate visitDate;

    private String weekDay;

    private String discountName;

    private Integer toPay;



}
