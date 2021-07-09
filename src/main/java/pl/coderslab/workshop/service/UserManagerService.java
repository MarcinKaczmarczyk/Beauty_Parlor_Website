package pl.coderslab.workshop.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.workshop.model.converter.UserConverter;
import pl.coderslab.workshop.model.dto.UserRegisterDto;
import pl.coderslab.workshop.repository.UserRepository;

@Service
@Transactional
public class UserManagerService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserConverter userConverter;


    public UserManagerService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userConverter = userConverter;
    }

    public void registerUser(UserRegisterDto user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole("ROLE_USER");
        userRepository.save(userConverter.toUserRegister(user));
    }
}
