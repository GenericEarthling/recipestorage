package com.atomic.recipestorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.atomic.recipestorage.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO
	}
	
	// enable users in the database and define a password hashing algorithm
	// this uses the BCrypt algorithm using Spring Security class
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}

/*	// ********** DEVELOPMENT PHASE ONLY *************
	// add in-memory users to the app. It will create a user with 
	//     user: user & password: password.
	// afterwards, CONVERT TO DB *********************
	@Bean
	@Override
	public UserDetailsService userDetailsService () {
		UserDetails user = 
				User.withDefaultPasswordEncoder()
					.username("user")
					.password("password")
					.roles("USER")
					.build();
		return new InMemoryUserDetailsManager();
		
	}
*/	
}
