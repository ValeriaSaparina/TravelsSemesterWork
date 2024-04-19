package com.example.semesterwork.service.user;

import com.example.semesterwork.dto.UserDto;
import com.example.semesterwork.entity.UserEntity;
import com.example.semesterwork.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public void addUser(UserEntity userEntity) {
        repository.save(userEntity);
    }

    @Override
    public UserDto getUserById(Long id) {
        return null;
    }

}
