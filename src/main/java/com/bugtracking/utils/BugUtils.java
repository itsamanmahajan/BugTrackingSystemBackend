package com.bugtracking.utils;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class BugUtils {

	private static final Random RANDOM = new SecureRandom();

	private static final String ALPHABET = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public String generateUserId(int length) {
		return generateRandomUserId(length);
	}


	public String generateProjectId(int length) {
		return generateRandomUserId(length);
	}

	public String generateBugId(int length) {
		return generateRandomUserId(length);
	}

	private String generateRandomUserId(int length) {
		StringBuilder returnValue = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return returnValue.toString();
	}

}
