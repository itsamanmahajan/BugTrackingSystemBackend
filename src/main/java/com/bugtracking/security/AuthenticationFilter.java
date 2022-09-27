package com.bugtracking.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bugtracking.SpringApplicationContext;
import com.bugtracking.shared.ErrorMessages;
import com.bugtracking.shared.UserLoginRequestModel;
import com.bugtracking.user.IUserService;
import com.bugtracking.user.UserResponseWrapper;
import com.bugtracking.user.UserServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			UserLoginRequestModel cred = new ObjectMapper().readValue(request.getInputStream(),
					UserLoginRequestModel.class);
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(cred.getEmail(), cred.getPassword(), new ArrayList<>()));

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String username = ((User) authResult.getPrincipal()).getUsername();

		String token = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.getExpritionTime()))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret()).compact();

		IUserService userService = (IUserService) SpringApplicationContext.getBean("UserServiceImpl");

		UserResponseWrapper userDetails = userService.getUserByEmail(username);

		response.addHeader(SecurityConstants.getHeaderString(), SecurityConstants.getTokenPrefix() + token);
		response.addHeader("UserId", userDetails.getUserId());
		response.addHeader("UserRole", userDetails.getRole().name());
		response.addHeader("UserEmail", userDetails.getEmail());
		response.addHeader("UserName", userDetails.getFirstName()+" "+userDetails.getLastName());
	}

}
