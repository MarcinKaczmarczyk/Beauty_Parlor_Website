package pl.coderslab.workshop.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.workshop.model.entity.User;
import pl.coderslab.workshop.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser=userRepository.findByUserName(username);
        return optionalUser.map(user -> new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole()))
        ))
                .orElseThrow(()-> new UsernameNotFoundException("Username"+username+"not found"));

    }

}
