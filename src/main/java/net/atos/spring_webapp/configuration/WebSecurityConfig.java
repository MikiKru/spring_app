package net.atos.spring_webapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // żądania autoryzowane określoną rolą
                .antMatchers("/post&**").hasAnyRole("ROLE_USER", "ROLE_ADMIN")
                // pozostałe nie są autoryzowane
                .anyRequest().permitAll()
                .and().formLogin()
                .and().httpBasic();
    }

}
