package pl.coderslab.workshop.model.converter;


import org.springframework.stereotype.Component;
import pl.coderslab.workshop.model.dto.UserDashboardDto;
import pl.coderslab.workshop.model.dto.UserRegisterDto;
import pl.coderslab.workshop.model.entity.User;
import pl.coderslab.workshop.repository.UserRepository;
import pl.coderslab.workshop.service.DiscountService;

@Component
public class UserConverter {

    private final UserRepository userRepository;
    private final DiscountService discountService;


    public UserConverter(UserRepository userRepository, DiscountService discountService) {
        this.userRepository = userRepository;
        this.discountService = discountService;
    }

    public User toUserRegister(UserRegisterDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setRole(userDto.getRole());
        return user;
    }

    public UserDashboardDto toUserDashboardDto(String name) {
        User user = userRepository.findAllWithVisitsByUserName(name);
        System.out.println(user);
        UserDashboardDto dashboard = new UserDashboardDto();
        dashboard.setUserName(user.getUserName());
        dashboard.setName(user.getName());
        dashboard.setDiscounts(discountService.discountDashBoardValidation(user));
//        dashboard.setClientVisits(user.getClientVisits());

        return dashboard;
    }


}
