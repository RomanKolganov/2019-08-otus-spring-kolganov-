package me.kolganov.springsecurityformbased.hw11.config.security;

import me.kolganov.springsecurityformbased.hw11.dao.UserRepository;
import me.kolganov.springsecurityformbased.hw11.domain.Role;
import me.kolganov.springsecurityformbased.hw11.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException(login);
        }
        org.springframework.security.core.userdetails.User.UserBuilder builder =
                org.springframework.security.core.userdetails.User.withUsername(login);

        builder.password(user.getPassword());
        builder.roles(user.getRoles().stream().map(Role::getRole).collect(Collectors.joining()));
        return builder.build();
    }
}
