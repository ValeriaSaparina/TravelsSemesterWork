package com.example.semesterwork.config;

import com.example.semesterwork.places.mapper.PlaceMapper;
import com.example.semesterwork.places.mapper.ReviewPlaceMapper;
import com.example.semesterwork.places.repository.PlaceRepository;
import com.example.semesterwork.routes.mapper.RouteMapper;
import com.example.semesterwork.user.mapper.UserMapper;
import com.example.semesterwork.user.repo.UserRepo;
import com.example.semesterwork.util.MissingServletRequestParameterExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepo userRepo;
    private final PlaceRepository placeRepo;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvide = new DaoAuthenticationProvider();
        authProvide.setUserDetailsService(userDetailsService());
        authProvide.setPasswordEncoder(passwordEncoder());
        return authProvide;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    public RouteMapper routeMapper() {
        return new RouteMapper(placeMapper());
    }

    @Bean
    public ReviewPlaceMapper reviewPlaceMapper() {
        return new ReviewPlaceMapper(
                placeRepo,
                userRepo,
                userMapper(),
                placeMapper()
        );
    }


    @Bean
    public PlaceMapper placeMapper() {
        return new PlaceMapper();
    }

    @Bean
    public MissingServletRequestParameterExceptionHandler missingServletRequestParameterExceptionHandler() {
        return new MissingServletRequestParameterExceptionHandler();
    }
}