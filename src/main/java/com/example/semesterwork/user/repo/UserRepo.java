package com.example.semesterwork.user.repo;

import com.example.semesterwork.token.Token;
import com.example.semesterwork.user.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByEmail(String email);
    @Query(value = """
      select * from my_user
      """, nativeQuery = true)
    List<MyUser> findAllUsers();
}
