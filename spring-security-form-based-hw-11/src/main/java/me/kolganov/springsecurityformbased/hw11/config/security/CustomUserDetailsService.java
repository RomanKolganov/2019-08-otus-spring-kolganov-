package me.kolganov.springsecurityformbased.hw11.config.security;

import me.kolganov.springsecurityformbased.hw11.dao.UserRepository;
import me.kolganov.springsecurityformbased.hw11.domain.AppUser;
import me.kolganov.springsecurityformbased.hw11.domain.Role;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<AppUser> appUser = userRepository.findByLogin(login);
        if (!appUser.isPresent()) {
            throw new UsernameNotFoundException(login);
        }

        User.UserBuilder builder = User.withUsername(login);

        builder.password(appUser.get().getPassword());
        builder.roles(appUser.get().getRoles().stream().map(Role::getRole).collect(Collectors.joining()));
        return builder.build();
    }
}
