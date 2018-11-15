package com.onetodiez.garbagerecycler.exceptions;

/**
 * 
 * @author Oneto, Fernando
 * @author Diez, Lautaro
 * 
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	
	private static final String message = "User not found! Try again with another username. "
			+ "Usuario no encontrado! Intente nuevamente con otro nombre de usuario.";

	public UserNotFoundException () {
		super(message);
	}
}
