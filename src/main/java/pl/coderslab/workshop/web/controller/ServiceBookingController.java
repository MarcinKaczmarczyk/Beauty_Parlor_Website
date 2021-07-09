package pl.coderslab.workshop.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.workshop.model.dto.BookingVisitDto;
import pl.coderslab.workshop.model.dto.EmployeeFullNameDto;
import pl.coderslab.workshop.model.entity.ClientVisit;
import pl.coderslab.workshop.model.entity.Employee;
import pl.coderslab.workshop.model.entity.Service;
import pl.coderslab.workshop.model.ServiceCategory;
import pl.coderslab.workshop.repository.*;
import pl.coderslab.workshop.service.CalendarService;
import pl.coderslab.workshop.service.VisitHourService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Controller
@RequestMapping("/reservation")
public class ServiceBookingController {

    private final ServiceRepository serviceRepository;
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final VisitDayRepository visitDayRepository;
    private final VisitHourRepository visitHourRepository;
    private final CalendarService calendarService;
    private final ClientVisitRepository clientVisitRepository;
    private final VisitHourService visitHourService;
    private BookingVisitDto bookingVisitDto;
    private ClientVisit clientVisit;


    public ServiceBookingController(ServiceRepository serviceRepository, EmployeeRepository employeeRepository, UserRepository userRepository, VisitDayRepository visitDayRepository, VisitHourRepository visitHourRepository, CalendarService calendarService, ClientVisitRepository clientVisitRepository, VisitHourService visitHourService) {
        this.serviceRepository = serviceRepository;
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
        this.visitDayRepository = visitDayRepository;
        this.visitHourRepository = visitHourRepository;
        this.calendarService = calendarService;


        this.clientVisitRepository = clientVisitRepository;
        this.visitHourService = visitHourService;
    }


    @GetMapping("/service")
    public String prepareServiceList(Model model, Authentication currentUser) {
        bookingVisitDto = new BookingVisitDto();
        clientVisit = userRepository.fillInClientVisitByUsername(currentUser.getName());
        model.addAttribute("cosmetic", ServiceCategory.COSMETIC);
        model.addAttribute("hairdressing", ServiceCategory.HAIRDRESSING);

        return "reservation/service-category-reservation";
    }

    @PostMapping("/service")
    public String processServiceList(ServiceCategory category, Model model) {
        if (category.equals(ServiceCategory.COSMETIC) || category.equals(ServiceCategory.HAIRDRESSING)) {
            clientVisit.setCategory(category);
            bookingVisitDto.setCategory(category);
            model.addAttribute("serviceList", serviceRepository.findAllByServiceCategory(category));
            return "reservation/service-list-reservation";
        }

        return "reservation/error";
    }

    @PostMapping("/visit")
    public String processVisit(String serviceName, Model model) {
        Service service = serviceRepository.findByName(serviceName);
        clientVisit.setService(service);
        model.addAttribute("employeeList", employeeRepository.findAllByServicesName(serviceName));
        bookingVisitDto.setServiceName(serviceName);
        bookingVisitDto.setServiceTime(service.getExecutionTime());
        bookingVisitDto.setPrice(service.getPrice());


        return "reservation/select-employee-reservation";
    }

    @PostMapping("/visitDate")
    public String processVisitData(String username, Model model) {
        Employee employee = employeeRepository.getFirstByUserName(username);
        clientVisit.setEmployee(employee);
        EmployeeFullNameDto fullName = employeeRepository.findFullNameByUserName(username);
        bookingVisitDto.setEmployeeUserName(username);
        bookingVisitDto.setEmployeeName(fullName.getFullName());
        model.addAttribute("dateList", visitDayRepository.findAllDateByEmployeeUserName(username));

        //        System.out.println("!#$!$!");
//        System.out.println("!#$!$!");
//        System.out.println("!#$!$!");
//        System.out.println(clientVisitDto);
////        System.out.println(visitDayRepository.findAllToMapaByEmployeeUserName(username));
//        System.out.println(visitHourRepository.findAllByVisitDate(LocalDate.now(),clientVisitDto.getEmployeeUserName()));
//        System.out.println("!#$!$!");
//        System.out.println("!#$!$!");
//        System.out.println("!#$!$!");

        return "reservation/select-data-reservation";
    }


    @PostMapping("/visitTime")
    public String prepareVisitTime(String dateList, Model model) {
        LocalDate visitDay = LocalDate.parse(dateList);
        clientVisit.setVisitDays(visitDayRepository.getFirstByEmployeeAndVisitDate(clientVisit.getEmployee(), visitDay));
       clientVisit.setVisitHours(clientVisit.getVisitDays().getVisitHours());
        bookingVisitDto.setVisitDay(visitDay);
        List<LocalTime> timeList = visitHourRepository.findAllHoursByVisitDateAndEmployee(visitDay, bookingVisitDto.getEmployeeUserName());
        model.addAttribute("timeList", calendarService.proposedTimesList(timeList, bookingVisitDto.getServiceTime()));

        return "reservation/select-time-reservation";
    }

    @PostMapping("/bookingSummary")
    public String prepareBookingSummary(String time, Model model, Authentication currentUser) {
        LocalTime visitTime = LocalTime.parse(time);
        bookingVisitDto.setVisitHours(visitTime);
        System.out.println("!@#!$!$!#$@!$");
        System.out.println("!@#!$!$!#$@!$");
        System.out.println("!@#!$!$!#$@!$");
        System.out.println(visitHourService.fillHourInArray(clientVisit.getVisitHours(), bookingVisitDto.getVisitHours(), bookingVisitDto.getServiceTime()));
        clientVisit.setVisitHours(visitHourService.fillHourInArray(clientVisit.getVisitHours(),bookingVisitDto.getVisitHours(),bookingVisitDto.getServiceTime()));

        model.addAttribute("bookingVisit", bookingVisitDto);
        return "reservation/summary-booking";
    }

    @PostMapping("/confirmation")
    public String prepareConfirmation(String bool, Model model) {
        boolean buttonVal = Boolean.parseBoolean(bool);
        if (buttonVal) {

            clientVisitRepository.save(clientVisit);
          return "redirect:/user-app"; /*To tylko tymczasowo*/
            /*return "reservation/confirmation-reservation";*/
        }
        if (!buttonVal) {
            return "redirect:/user-app";
        }

        return "reservation/error";
    }
}
