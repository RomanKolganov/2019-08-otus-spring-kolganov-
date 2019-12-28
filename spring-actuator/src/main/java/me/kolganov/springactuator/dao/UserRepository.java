package me.kolganov.springactuator.dao;

import me.kolganov.springactuator.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByLogin(String login);
}
