package com.LuckBattle.Webservices.repository;

import com.LuckBattle.Webservices.entity.ERole;
import com.LuckBattle.Webservices.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
