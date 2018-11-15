package com.onetodiez.garbagerecycler.exceptions;
/**
 * 
 * Exception Handler Controller
 * 
 * @author Oneto, Fernando
 * @author Diez, Lautaro
 * 
 */
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.onetodiez.garbagerecycler.model.ErrorDetail;

@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	// Handling an exception when the user already exists in the data base.
	@ExceptionHandler(UserAlreadyExistsException.class)
	public final ResponseEntity<ErrorDetail> handleUserAlreadyExistException(UserAlreadyExistsException ex, HttpServletRequest request) {
		ErrorDetail errorDetails = new ErrorDetail(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	// Handling an exception when there are incorrect fields 
	@ExceptionHandler(IncorrectJsonFieldsException.class)
	public final ResponseEntity<ErrorDetail> handleIncorrectJsonFieldsException(IncorrectJsonFieldsException ex, HttpServletRequest request) {
		ErrorDetail errorDetails = new ErrorDetail(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	// Handling an exception when the user is not found
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetail> handleIncorrectJsonFieldsException(UserNotFoundException ex, HttpServletRequest request) {
		ErrorDetail errorDetails = new ErrorDetail(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
