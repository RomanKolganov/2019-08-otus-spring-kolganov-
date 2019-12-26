package me.kolganov.springactuator.security;

import me.kolganov.springactuator.dao.UserRepository;
import me.kolganov.springactuator.domain.Role;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login).map(u -> User.withUsername(login)
                .password(u.getPassword())
                .roles(u.getRoles().stream().map(Role::getRole).collect(Collectors.joining()))
        ).orElseThrow(() -> new UsernameNotFoundException(login)).build();
    }
}
