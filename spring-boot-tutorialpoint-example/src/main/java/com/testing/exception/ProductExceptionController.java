package com.testing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<Object> exception(ProductNotFoundException exception) {
		return new ResponseEntity<>("Product not found!!", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = InvalidProductNameException.class)
	public ResponseEntity<Object> exception(InvalidProductNameException exception) {
		return new ResponseEntity<>("Invalid product name", HttpStatus.BAD_REQUEST);
	}
}
