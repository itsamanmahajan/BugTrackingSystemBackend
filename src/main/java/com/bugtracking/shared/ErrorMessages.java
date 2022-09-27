package com.bugtracking.shared;

public enum ErrorMessages {

	MISSIING_REQUIRED_FIELD("Missing required field, Please check documentation for required fields"),
	RECORD_ALREADY_EXISTS("Record already exits"), 
	INTERNAL_SERVER_ERROR("Internal server error"),
	NO_RECORD_FOUND("Record with provided id is not found"), 
	AUTHENTICATION_FAILED("Authentication failed"),
	COULD_NOT_UPDATE_RECORD("Could not update record"), 
	COULD_NOT_DELETE_RECORD("Could not delete record"),
	NO_BUG_FOUND_FOR_USER("Could not any bug for user");

	private String errorMessage;

	private ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
