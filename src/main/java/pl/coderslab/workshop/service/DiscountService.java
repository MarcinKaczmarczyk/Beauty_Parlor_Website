package pl.coderslab.workshop.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.coderslab.workshop.model.entity.Discount;
import pl.coderslab.workshop.model.entity.User;
import pl.coderslab.workshop.repository.DiscountRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.util.Optional;
import java.util.Set;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;

    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    //TODO Tutaj można zrobić fajny design ze wzorcami projektowymi
    /*
        Przygotować interface:

        public interface DiscountStrategy {

            boolean availableDiscount(User user);

            void applyDiscount(User user);
     */

    /*
        @Component
        WomenDayDiscountStrategy implements DiscountStrategy {

            public boolean availableDiscount(User user) {
                return LocalDate.now().getMonth().equals(Month.of(3)) && LocalDate.now().getDayOfMonth() == 8;
            }

            public void applyDiscount(User user) {
            // zastosowanie zniżki
            }
     */

    /*
    W serwisie:

    @Autowired
        List<DiscountStrategy> strategies;
     */

    /*
        W konkretniej metodzie:

        User user = ...;
        strategies.stream().filter(DiscountStrategy::availableDiscount).forEach(DiscountStrategy::applyDiscount);

        for (DiscountStrategy strategy : strategies) {
            if (strategy.availableDiscount(user)) {
                  strategy.applyDiscount(user);
          }
      }
     */
    public Set<Discount> discountDashBoardValidation(User user) {
        Set<Discount> discounts = user.getDiscounts();

        if (isBirthday(user.getDateOfBirth())) {
            Optional<Discount> discountBirthday = discountRepository.getByName("urodzinowy");
            discountBirthday.ifPresent(discounts::add);
        }else {
            discounts.removeIf(d->d.getName().equals("urodzinowy"));
        }

        if (isTheTenthVisit(user)) {
            Optional<Discount> discountVisits = discountRepository.getByName("frekwencyjny");
            discountVisits.ifPresent(discounts::add);
        }else {
            discounts.removeIf(d->d.getName().equals("frekwencyjny"));
        }

        if (isWomanDay()) {
            Optional<Discount> discountVisits = discountRepository.getByName("dzień kobiet");
            discountVisits.ifPresent(discounts::add);
        }else {
            discounts.removeIf(d->d.getName().equals("dzień kobiet"));
        }
        //TODO dodaj płeć w encji user
        if (isChildrenDay()) {
            if (userAge(user)<18) {
                Optional<Discount> discountVisits = discountRepository.getByName("dzień dziecka");
                discountVisits.ifPresent(discounts::add);
            }
        }else {
            discounts.removeIf(d->d.getName().equals("dzień dziecka"));
        }

        return discounts;
    }
//    TODO dorobić relacje w discount do service
//    public Discount discountVisitBookingValidation(User user) {
//     Set<Discount> discounts=discountDashBoardValidation(user);
//
//
//        return discount;
//    }

    private boolean isBirthday(LocalDate birthday) {
        return LocalDate.now().getMonth().equals(birthday.getMonth()) && LocalDate.now().getDayOfMonth() == birthday.getDayOfMonth();
    }

    private boolean isTheTenthVisit(User user) {
        return user.getVisits() % 10 == 0;
    }

    private boolean isChildrenDay() {
        return LocalDate.now().getMonth().equals(Month.of(6)) && LocalDate.now().getDayOfMonth() == 28;
    }

    private boolean isWomanDay() {
        return LocalDate.now().getMonth().equals(Month.of(3)) && LocalDate.now().getDayOfMonth() == 8;
    }

    private int userAge(User user){
        int age=LocalDate.now().getYear()-user.getDateOfBirth().getYear();
       if (MonthDay.now().isBefore(MonthDay.of(user.getDateOfBirth().getMonth(),user.getDateOfBirth().getDayOfMonth()))){
           age-=1;
        }
        return age;
    }

//    public Map<ServiceCategory,Integer> countingVisits(List<ClientVisit> visits){
//        for (ClientVisit visit : visits) {
//            if (visit.)
//        }
//    }
}
