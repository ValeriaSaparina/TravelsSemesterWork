package com.example.semesterwork.user.repo;

import com.example.semesterwork.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
