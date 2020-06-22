////package com.finchFood.utils;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers("/service/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .antMatchers(HttpMethod.DELETE,"/carro").permitAll()
//                .antMatchers("/login**","/users**","/sessions/**").hasRole("ADMIN")
//                .antMatchers("/pessoa/**","/signup").permitAll()
//                .anyRequest().hasRole("USER")
//                .and()
//            .jee()
//                .mappableRoles("ROLE_USER","ROLE_ADMIN");
//        
////        antMatchers(HttpMethod.GET, "/rest/v1/session/login").permitAll().
////        antMatchers(HttpMethod.POST, "/rest/v1/session/register").permitAll().
////        antMatchers(HttpMethod.GET, "/rest/v1/session/logout").authenticated().
////        antMatchers(HttpMethod.GET, "/rest/v1/**").hasAuthority("ADMIN").
////        antMatchers(HttpMethod.POST, "/rest/v1/**").hasAuthority("USER").
////        antMatchers(HttpMethod.PATCH, "/rest/v1/**").hasAuthority("USER").
////        antMatchers(HttpMethod.DELETE, "/rest/v1/**").hasAuthority("USER").
////        anyRequest().permitAll();
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//    }
//}