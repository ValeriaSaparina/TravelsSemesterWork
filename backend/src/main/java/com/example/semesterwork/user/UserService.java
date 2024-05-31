package com.example.semesterwork.user;

import com.example.semesterwork.admin.BlockRequest;
import com.example.semesterwork.user.dto.UserDto;
import com.example.semesterwork.user.mapper.UserMapper;
import com.example.semesterwork.user.model.UserModel;
import com.example.semesterwork.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (UserModel) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        userRepo.save(user);
    }

    public List<UserDto> findAll() {
        return userRepo.findAll().stream().map(userMapper::entityToDto).collect(Collectors.toList());
    }

    public UserDto updBlockUser(BlockRequest request) {
        UserModel userModel = userRepo.findByEmail(request.getEmail()).orElseThrow();
        userModel.setIsBlocked(request.getIsBlocked());
        userRepo.save(userModel);
        return userMapper.entityToDto(userModel);
    }
}