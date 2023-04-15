package br.com.mesaquebatista.verbify.exceptions;

import org.springframework.http.HttpStatus;

public class DataNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private HttpStatus httpCode = HttpStatus.NOT_FOUND;

	public DataNotFoundException(String message) {
		super(message);
	}
	
	public DataNotFoundException(String message, HttpStatus httpCode) {
		super(message);
		this.httpCode = httpCode;
	}
	
	public HttpStatus getHttpCode() {
		return httpCode;
	}

}
