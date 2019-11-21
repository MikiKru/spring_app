package net.atos.spring_webapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Configuration
public class BeanConfiguration {

    @Bean
    public PasswordEncoder getBCryptEncoder(){
        return new BCryptPasswordEncoder();
    }
}
