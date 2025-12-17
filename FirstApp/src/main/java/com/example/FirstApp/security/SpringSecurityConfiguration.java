package com.example.FirstApp.security;

import org.springframework.context.annotation.Bean;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails1 = createNewUser("RAM", "12345");
        UserDetails userDetails2 = createNewUser("BANDARU", "123456");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        return User.builder()
                .username(username)
                .password(passwordEncoder().encode(password))
                .roles("USER")   // assign roles as needed
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } 

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll()   // allow public endpoints
                .anyRequest().authenticated()                // everything else requires login
        )
        .formLogin(withDefaults())   // enable default login page at /login
        .logout(withDefaults());     // enable default logout

        http.csrf(csrf -> csrf.disable());  // disable CSRF for simplicity during dev
        return http.build();
    }
}
