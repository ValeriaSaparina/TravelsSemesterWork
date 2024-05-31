package com.example.semesterwork.user.repo;

import com.example.semesterwork.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);

    @Query(value = """
            select * from users
            """, nativeQuery = true)
    List<UserModel> findAllUsers();
}
