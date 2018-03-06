package com.senla.bolkunets.virtualtestlab.security.config;

import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.RoleUser;
import com.senla.bolkunets.virtualtestlab.security.filters.TokenAuthenticationFilter;
import com.senla.bolkunets.virtualtestlab.security.services.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @Bean
    public TokenAuthenticationFilter getTokenAuthenticationFilter(){
        TokenAuthenticationFilter tokenAuthenticationFilter = new TokenAuthenticationFilter(tokenAuthenticationService);
        return tokenAuthenticationFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/users/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/methodics/description/all").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterAfter(getTokenAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable();
    }
}
