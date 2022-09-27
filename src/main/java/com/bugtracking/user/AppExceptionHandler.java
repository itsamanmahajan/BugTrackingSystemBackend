package com.bugtracking.user;

import java.util.Date;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.bugtracking.user.shared.ErrorMessage;

public class AppExceptionHandler {

	public static final Logger logger = LogManager.getLogger(AppExceptionHandler.class);

	/**
	 * Method used to catch and log all exception
	 * 
	 * @return {@code  ResponseEntity<Object> }
	 * 
	 **/
	@ExceptionHandler(value = Exception.class)
	public static ResponseEntity<Object> universalExceptionHandler(Exception exception, WebRequest request) {
		logger.error("Exception:: {}", ExceptionUtils.getStackTrace(exception));
		return new ResponseEntity<>(new ErrorMessage(exception.getMessage(), new Date()), new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
