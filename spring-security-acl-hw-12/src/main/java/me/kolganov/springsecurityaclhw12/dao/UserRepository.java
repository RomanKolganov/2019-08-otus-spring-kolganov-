package me.kolganov.springsecurityaclhw12.dao;

import me.kolganov.springsecurityaclhw12.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByLogin(String login);
}
