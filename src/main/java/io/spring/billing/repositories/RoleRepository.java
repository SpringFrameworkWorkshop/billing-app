package io.spring.billing.repositories;

import io.spring.billing.entities.Role;
import io.spring.billing.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Role findByName(String name);
}
