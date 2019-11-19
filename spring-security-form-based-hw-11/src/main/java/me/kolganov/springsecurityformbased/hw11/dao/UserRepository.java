package me.kolganov.springsecurityformbased.hw11.dao;

import me.kolganov.springsecurityformbased.hw11.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByLogin(String login);
}
