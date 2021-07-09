package pl.coderslab.workshop.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.workshop.service.CalendarService;
import pl.coderslab.workshop.model.entity.*;
import pl.coderslab.workshop.model.ServiceCategory;
import pl.coderslab.workshop.repository.*;

import javax.annotation.PostConstruct;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Component
@Slf4j
public class DataSetup {

    private final AdminRepository adminRepo;
    private final ClientVisitRepository clientVisitRepo;
    private final EmployeeRepository employeeRepo;
    private final OpeningHourRepository openingHourRepo;
    private final DiscountRepository discountRepo;
    private final ServiceRepository serviceRepo;
    private final UserRepository userRepo;
    private final VisitDayRepository visitDayRepo;
    private final VisitHourRepository visitHourRepo;
    private final WorkHourRepository empCalRepo;
    private final CalendarService calendarService;

    public DataSetup(AdminRepository adminRepo, ClientVisitRepository clientVisitRepo, EmployeeRepository employeeRepo, OpeningHourRepository openingHourRepo, DiscountRepository discountRepo, ServiceRepository serviceRepo, UserRepository userRepo, VisitDayRepository visitDayRepository, VisitHourRepository visitHourRepo, WorkHourRepository empCalRepo, CalendarService calendarService) {
        this.adminRepo = adminRepo;
        this.clientVisitRepo = clientVisitRepo;
        this.employeeRepo = employeeRepo;
        this.openingHourRepo = openingHourRepo;
        this.discountRepo = discountRepo;
        this.serviceRepo = serviceRepo;
        this.userRepo = userRepo;
        this.visitDayRepo = visitDayRepository;
        this.visitHourRepo = visitHourRepo;
        this.empCalRepo = empCalRepo;
        this.calendarService = calendarService;
    }

    @PostConstruct
    @Transactional
    public void setupData() {
        adminRepo.save(new Admin(null, "Admin1", "{noop}Admin1", "Admin1", "Admin1", "543543234"));
        setupVisits();
        setupOpeningHours();
        setupServices();
        setupEmployees();
        setupDiscounts();
        setupUsers();
//        setupVisitDate();
        calendarService.createDays();
    }

    private void setupVisitDate() {
//        visitDayRepo.save(new VisitDay(null,null/*ServiceCategory.HAIRDRESSING*/,LocalDate.of(2021,6,1),null));
//        visitDayRepo.save(new VisitDay(null,null/*ServiceCategory.HAIRDRESSING*/,LocalDate.of(2021,7,1),null));
//        visitDayRepo.save(new VisitDay(null,null/*ServiceCategory.HAIRDRESSING*/,LocalDate.of(2021,7,2),null));
//        visitDayRepo.save(new VisitDay(null,null/*ServiceCategory.HAIRDRESSING*/,LocalDate.of(2021,8,1),null));
//        visitDayRepo.save(new VisitDay(null,null/*ServiceCategory.HAIRDRESSING*/,LocalDate.of(2021,9,1),null));
//        visitDayRepo.save(new VisitDay(null,null/*ServiceCategory.HAIRDRESSING*/,LocalDate.of(2021,10,1),null));
//        visitDayRepo.save(new VisitDay(null,null/*ServiceCategory.HAIRDRESSING*/,LocalDate.of(2021,6,3),null));
//        visitDayRepo.save(new VisitDay(null,null/*ServiceCategory.HAIRDRESSING*/,LocalDate.of(2021,6,4),null));
//        visitDayRepo.save(new VisitDay(null,null/*ServiceCategory.HAIRDRESSING*/,LocalDate.of(2021,6,5),null));
//        visitDayRepo.save(new VisitDay(null,null/*ServiceCategory.HAIRDRESSING*/,LocalDate.of(2021,6,7),null));
//        visitDayRepo.save(new VisitDay(null,null/*ServiceCategory.HAIRDRESSING*/,LocalDate.of(2021,6,8),null));
    }

    public void setupVisits() {
        for (int i = 0; i < 5; i++) {
            if (i < 3) {
                clientVisitRepo.save(new ClientVisit(null, "Władzio" + i, "Pierożek" + i, "543546645", ServiceCategory.COSMETIC, null, null,null,null));
            }else {
                clientVisitRepo.save(new ClientVisit(null, "Władzio" + i, "Pierożek" + i, "543546645", ServiceCategory.HAIRDRESSING, null, null,null,null));
            }
        }
    }

    public void setupOpeningHours() {
        openingHourRepo.save(new OpeningHour(null, DayOfWeek.MONDAY, LocalTime.of(9, 00), LocalTime.of(18, 00)));
        openingHourRepo.save(new OpeningHour(null, DayOfWeek.TUESDAY, LocalTime.of(9, 00), LocalTime.of(18, 00)));
        openingHourRepo.save(new OpeningHour(null, DayOfWeek.WEDNESDAY, LocalTime.of(9, 00), LocalTime.of(18, 00)));
        openingHourRepo.save(new OpeningHour(null, DayOfWeek.THURSDAY, LocalTime.of(9, 00), LocalTime.of(18, 00)));
        openingHourRepo.save(new OpeningHour(null, DayOfWeek.FRIDAY, LocalTime.of(9, 00), LocalTime.of(18, 00)));
        openingHourRepo.save(new OpeningHour(null, DayOfWeek.SATURDAY, LocalTime.of(9, 00), LocalTime.of(16, 00)));
        openingHourRepo.save(new OpeningHour(null, DayOfWeek.SUNDAY, null, null));

    }

    public void setupEmployees() {
        Set<WorkHour>workHours= loadWorkHour();
        Set<Service>hairService=serviceRepo.findAllByServiceCategory(ServiceCategory.HAIRDRESSING);
        Set<Service>cosmeticService=serviceRepo.findAllByServiceCategory(ServiceCategory.COSMETIC);

        employeeRepo.save(new Employee(null, "KaWie", "{noop}hasłoOkon",
                "Kasia", "Wieczorek", ServiceCategory.HAIRDRESSING,workHours,null,hairService));

        employeeRepo.save(new Employee(null, "PaKam", "{noop}ptakiLatajaKluczem",
                "Patrycja", "Kamińska", ServiceCategory.HAIRDRESSING,workHours,null,hairService));

        employeeRepo.save(new Employee(null, "MiZel", "{noop}inne",
                "Mirosław", "Zelent", ServiceCategory.COSMETIC,workHours,null,cosmeticService));

        employeeRepo.save(new Employee(null, "MaKow", "{noop}tajneHaslo",
                "Mariola", "Kowalik", ServiceCategory.COSMETIC,workHours,null, cosmeticService));
    }
//    private List<Service> hairdressingService(){
//       return serviceRepo.findAllByServiceCategory(ServiceCategory.HAIRDRESSING);
//    }
//    private List<Service> cosmeticService(){
//        return serviceRepo.findAllByServiceCategory(ServiceCategory.COSMETIC);
//    }

    private Set<WorkHour> loadWorkHour(){
        Set<WorkHour> calendars=new HashSet<>();
        LocalDate dateToSave=LocalDate.now();
        LocalDate dateWithPlusMonth=LocalDate.now().plusMonths(1L);
        while (!dateToSave.equals(dateWithPlusMonth)){
            if (!dateToSave.getDayOfWeek().equals(DayOfWeek.SUNDAY)&&!dateToSave.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
            WorkHour empCalendar= new WorkHour(null,LocalTime.of(9,00),LocalTime.of(12,00),dateToSave);
         empCalRepo.save(empCalendar);
         calendars.add(empCalendar);
            }
            if (dateToSave.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
                WorkHour empCalendar=new WorkHour(null,LocalTime.of(9,00),LocalTime.of(12,00),dateToSave);
                empCalRepo.save(empCalendar);
                calendars.add(empCalendar);
            }
            dateToSave=dateToSave.plusDays(1L);
        }
        return calendars;
    }

    public void setupServices() {
        Set<Employee> hairdresser = employeeRepo.findAllByServiceCategory(ServiceCategory.HAIRDRESSING);
        Set<Employee> cosmetologist = employeeRepo.findAllByServiceCategory(ServiceCategory.COSMETIC);
        serviceRepo.save(new Service(null, "strzyżenie męskie", "opis1",
                LocalTime.of(0, 20), 20, ServiceCategory.HAIRDRESSING/*, hairdresser*/));
        serviceRepo.save(new Service(null, "farbowanie", "opis2",
                LocalTime.of(1, 30), 150, ServiceCategory.HAIRDRESSING/*, hairdresser*/));
        serviceRepo.save(new Service(null, "pasemka", "opis3",
                LocalTime.of(1, 20), 70, ServiceCategory.HAIRDRESSING/*, hairdresser*/));
        serviceRepo.save(new Service(null, "oczyszczanie wodorowe", "opis4",
                LocalTime.of(0, 40), 200, ServiceCategory.COSMETIC/*, cosmetologist*/));
        serviceRepo.save(new Service(null, "henna", "opis5",
                LocalTime.of(1, 00), 50, ServiceCategory.COSMETIC/*, cosmetologist*/));
        serviceRepo.save(new Service(null, "maseczka odmładzająca", "opis6",
                LocalTime.of(0, 20), 60, ServiceCategory.COSMETIC/*, cosmetologist*/));
        serviceRepo.save(new Service(null, "Masaż twarzy", "opis7",
                LocalTime.of(1, 10), 140, ServiceCategory.COSMETIC/*, cosmetologist.stream()
                .filter(e -> e.getName().equals("Mirosław")).collect(Collectors.toSet())*/));
    }

    public void setupDiscounts() {

        discountRepo.save(new Discount("frekwencyjny",
                "darmowe strzyżenie co 10 wizytę", 1.00, new HashSet<>(Arrays.asList(serviceRepo.getOne(1L)))));
        discountRepo.save(new Discount("dzień kobiet",
                "-15% na wszystkie zabiegi dla pań", 0.15, new HashSet<>(serviceRepo.findAll())));
        discountRepo.save(new Discount("dzień dziecka",
                "-30% na strzyżenie dla dzieci do 3 roku życia xD",
                0.30, new HashSet<>(Arrays.asList(serviceRepo.getOne(1L)))));
        discountRepo.save(new Discount("urodzinowy",
                "-15% na wszystkie usługi usługi",
                0.30, new HashSet<>(serviceRepo.findAll())));
    }

    public void setupUsers() {
        userRepo.save(new User(null, "ROLE_USER", "user1", "{noop}q", "name1", "surname1", "543345543",
                LocalDate.of(1995, 6, 28),
                new HashSet<>(Arrays.asList(clientVisitRepo.getOne(1L), clientVisitRepo.getOne(2L))),
                new HashSet<>(Arrays.asList(discountRepo.getOne(1L))), 20));
        userRepo.save(new User(null, "ROLE_USER", "user2", "{noop}qwertyui", "name2", "surname2", "543345998",
                LocalDate.of(2010, 6, 17),
                new HashSet<>(Arrays.asList(clientVisitRepo.getOne(3L))),
                new HashSet<>(Arrays.asList(discountRepo.getOne(3L))), 19));

        userRepo.save(new User(null, "ROLE_USER", "user3", "{noop}qwertyasd", "name3", "surname3", "656345543",
                LocalDate.of(1976, 3, 13),
                new HashSet<>(Arrays.asList(clientVisitRepo.getOne(4L), clientVisitRepo.getOne(5L))),
                new HashSet<>(Arrays.asList(discountRepo.getOne(2L))), 4));
        userRepo.save(new User(null, "ROLE_USER", "user4", "{noop}qwertyhhh", "name4", "surname4", "543345003",
                LocalDate.of(1997, 1, 15),
                null, null, 0));
    }
//    public void setupVisitDay(){
//        visitDayRepo.save()
//    }


}
