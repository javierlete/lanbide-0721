package com.ipartek.formacion.springmvc.configuraciones;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.*;
import org.springframework.security.web.*;

@Configuration
public class SecurityConfiguration {
    @Bean
    InMemoryUserDetailsManager userDetailsService() {
        @SuppressWarnings("deprecation")
		UserDetails user = User.withDefaultPasswordEncoder().username("admin").password("contra").roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
	
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().permitAll()
			.and()
		.formLogin()
			//.loginPage("/login")
			.permitAll()
			.and()
		.logout()
			.permitAll();
        return http.build();
    }
}
