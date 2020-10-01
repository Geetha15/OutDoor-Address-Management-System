package com.capg.go.address.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class AddressException {
	

	@ExceptionHandler(AddressNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = " Address Not Found", code = HttpStatus.NOT_FOUND)
	public void addressNotFoundException() {

	}

	@ExceptionHandler(AddressAlreadyExistException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = " Address Already Exists")
	public void addressAlreadyExistsException() {
		
	}
}
