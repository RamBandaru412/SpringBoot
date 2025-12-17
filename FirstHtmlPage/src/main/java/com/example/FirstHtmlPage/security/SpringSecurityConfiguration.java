package com.example.FirstHtmlPage.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
    	
    
        UserDetails userDetails1 = createNewUser("RAM", "12345");
        UserDetails userDetails2 = createNewUser("BANDARU", "123456");

        

        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }

	private UserDetails createNewUser(String username, String password) {
		UserDetails userDetails = User.builder()
                .username(username)
                .password(passwordEncoder().encode(password))
                .roles("USER", "ADMIN")
                .build();
		return userDetails;
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } 
   

}

