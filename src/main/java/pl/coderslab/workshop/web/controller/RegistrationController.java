package pl.coderslab.workshop.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.workshop.model.dto.UserRegisterDto;
import pl.coderslab.workshop.service.UserManagerService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final UserManagerService userManagerService;

    public RegistrationController(UserManagerService userManagerService) {
        this.userManagerService = userManagerService;
    }

    @GetMapping
    public String prepareRegistrationPage(Model model){
        model.addAttribute("user",new UserRegisterDto());
        return "registration";
    }
    @PostMapping
    public String processRegistrationPage(UserRegisterDto user){
//        UserRegisterDto userReg=user;
        user.setDateOfBirth(LocalDate.parse(user.getStrDateOfBirth()));
        userManagerService.registerUser(user);
        return "redirect:/login";
    }
}
