package me.kolganov.springsecurityformbased.hw11.dao;

import me.kolganov.springsecurityformbased.hw11.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
