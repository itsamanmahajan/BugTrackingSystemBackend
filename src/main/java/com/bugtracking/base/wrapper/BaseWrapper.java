package com.bugtracking.base.wrapper;

import java.time.LocalDateTime;

public class BaseWrapper {

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "BaseEntity [createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
