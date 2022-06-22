package com.ipartek.formacion.springmvc.configuraciones;

import javax.sql.*;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.provisioning.*;
import org.springframework.security.web.*;

@Configuration
public class SecurityConfiguration {
	// https://www.baeldung.com/spring-security-jdbc-authentication
	// https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
	
	@Bean
    UserDetailsManager users(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        return users;
    }
	 // https://bcrypt-generator.com/
	@Bean
	PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().permitAll()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
		.logout()
			.permitAll();
        return http.build();
    }
}
