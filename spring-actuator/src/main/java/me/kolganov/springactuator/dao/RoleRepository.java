package me.kolganov.springactuator.dao;

import me.kolganov.springactuator.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(String role);
}
