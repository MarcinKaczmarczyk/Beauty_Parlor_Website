package pl.coderslab.workshop.web.controller;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.workshop.repository.*;
import pl.coderslab.workshop.service.CalendarService;
import pl.coderslab.workshop.model.converter.UserConverter;

@Controller
@RequestMapping("/user-app")
public class UserController {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final VisitDayRepository visitDayRepository;
    private final CalendarService calendarService;
    private final ServiceRepository serviceRepository;
    private final EmployeeRepository employeeRepository;
    private final DiscountRepository discountRepository;


    public UserController(UserRepository userRepository, UserConverter userConverter, VisitDayRepository visitDayRepository, CalendarService calendarService, ServiceRepository serviceRepository, EmployeeRepository employeeRepository, DiscountRepository discountRepository) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.visitDayRepository = visitDayRepository;
        this.calendarService = calendarService;
        this.serviceRepository = serviceRepository;
        this.employeeRepository = employeeRepository;
        this.discountRepository = discountRepository;
    }

    @GetMapping
    private String prepareDashboard(Model model, Authentication currentUser) {
        if (currentUser != null && currentUser.getName() != null) {
            model.addAttribute("user",userConverter.toUserDashboardDto(currentUser.getName()));

//            do naszego spotkania postaram się żeby wyświetlały się tu zapisane wizyty
//            to zostawiłem żeby pokazać ci problem z employeem nie mam pojęcia czemu pobiera wszystko dla porównania dałem discounta
//            który swojej relacji nie pobiera
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#################################");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#################################");

            System.out.println(discountRepository.getFirstById(1L));

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#################################");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#################################");

            System.out.println(employeeRepository.getFirstById(1L));

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#################################");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#################################");
            }
        return "dashboard";
    }
}
