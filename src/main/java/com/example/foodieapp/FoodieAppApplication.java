package com.example.foodieapp;

import jakarta.servlet.DispatcherType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class FoodieAppApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FoodieAppApplication.class, args);
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize
//                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers("/", "/app", "/signup", "/home", "/error","/login", "/403", "/logoutSuccess").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .failureUrl("/login/fail")
                        .defaultSuccessUrl("/about")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // ścieżka do wylogowania
                        .logoutSuccessUrl("/logoutSuccess") // przekierowanie po wylogowaniu
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedPage("/403"))
                .build();
    }

}
