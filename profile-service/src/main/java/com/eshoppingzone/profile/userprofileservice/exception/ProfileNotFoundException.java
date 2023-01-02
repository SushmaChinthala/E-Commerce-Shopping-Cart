package com.eshoppingzone.profile.userprofileservice.exception;

public class ProfileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	public ProfileNotFoundException(String message) {

		super(message);
	}

	public ProfileNotFoundException() {

	}
}
