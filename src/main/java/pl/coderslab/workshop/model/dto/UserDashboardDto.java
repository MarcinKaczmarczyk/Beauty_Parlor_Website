package pl.coderslab.workshop.model.dto;


import lombok.Data;
import pl.coderslab.workshop.model.entity.ClientVisit;
import pl.coderslab.workshop.model.entity.Discount;
import pl.coderslab.workshop.model.ServiceCategory;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class UserDashboardDto {

    private String userName;

    private String name;

    private Set<Discount> discounts;

    private Map<DayOfWeek,List<ClientVisit>> clientVisits;

    private Map<ServiceCategory,Integer> visitsCounter;


}
