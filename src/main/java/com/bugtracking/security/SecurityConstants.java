package com.bugtracking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.bugtracking.SpringApplicationContext;

public class SecurityConstants {

	private SecurityConstants() {
	}

	private static ApplicationProperty applicationProperty;

	static {
		applicationProperty = (ApplicationProperty) SpringApplicationContext.getBean("applicationProperty");
	}

	public static final String SING_UP_URL = "/api/users/";

	public static String getTokenSecret() {
		return applicationProperty.getTokenSecret();
	}

	public static int getExpritionTime() {
		return Integer.parseInt(applicationProperty.getExpritionTime());
	}

	public static String getTokenPrefix() {
		return applicationProperty.getTokenPrefix();
	}

	public static String getHeaderString() {
		return applicationProperty.getHeaderString();
	}

}
