package com.bugtracking.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bugtracking.user.IUserService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private final IUserService detailsService;
	Logger logger = LogManager.getLogger(this.getClass());

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurity(IUserService detailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.detailsService = detailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("In P");
System.out.println(HttpMethod.POST);
System.out.println(SecurityConstants.SING_UP_URL);
		http.csrf().disable().cors().and().authorizeRequests()
				.antMatchers(HttpMethod.POST, SecurityConstants.SING_UP_URL).permitAll().anyRequest().authenticated()
				.and().addFilter(getAuthenticateFilter()).addFilter(new AuthorizationFilter(authenticationManager()))
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	private AuthenticationFilter getAuthenticateFilter() throws Exception {
		final AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager());
		authenticationFilter.setFilterProcessesUrl("/api/users/login");
		return authenticationFilter;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(detailsService).passwordEncoder(bCryptPasswordEncoder);
	}

}
