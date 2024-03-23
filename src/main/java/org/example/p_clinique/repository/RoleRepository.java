package org.example.p_clinique.repository;

import org.example.p_clinique.entities.EnRoleName;
import org.example.p_clinique.entities.Role;
import org.example.p_clinique.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
    Optional<Role> findByRoleName(String roleName);

}