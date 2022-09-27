package com.bugtracking.user.shared;

public class OperationStatusModel {

	private String operationStatus;

	private String operationName;

	public OperationStatusModel() {
	}

	public OperationStatusModel(String operationStatus, String operationName) {
		super();
		this.operationStatus = operationStatus;
		this.operationName = operationName;
	}

	public String getOperationStatus() {
		return operationStatus;
	}

	public void setOperationStatus(String operationStatus) {
		this.operationStatus = operationStatus;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

}
