/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.cctv.c4.controller;

import java.util.Collections;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camilo
 */
@RestController
public class LoginController /*extends WebSecurityConfigurerAdapter */{

    @GetMapping("/api/login")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
        
    }

    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	// @formatter:off
//        http.authorizeRequests(a -> a
//                .antMatchers("/", "/error", "/webjars/**", "/Skate", "/Reservation/**", "/Client/**"
//                , "/Category/**", "/Message/**", "/Score/**", "/Admin/**").permitAll()
//                .anyRequest().authenticated()
//            )
//            .exceptionHandling(e -> e
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//            )
//            .oauth2Login();
//        
//        http.cors().and().csrf().disable();
//        // @formatter:on
//    }
    
    
}


