package me.kolganov.springsecurityformbased.hw11.dao;

import me.kolganov.springsecurityformbased.hw11.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(String role);
}
