package me.kolganov.springsecurityformbased.hw11.service;

import me.kolganov.springsecurityformbased.hw11.dao.UserRepository;
import me.kolganov.springsecurityformbased.hw11.domain.CustomUserDetails;
import me.kolganov.springsecurityformbased.hw11.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        return new CustomUserDetails(user);
    }
}
