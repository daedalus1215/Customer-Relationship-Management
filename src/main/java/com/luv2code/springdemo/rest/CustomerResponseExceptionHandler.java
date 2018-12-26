package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerResponseExceptionHandler {

    // Add Exception Handling for CustomerNotFoundException
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {

        // Create CustomerErrorResponse
        CustomerErrorResponse errorResponse = new CustomerErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<CustomerErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Add Exception handling for everything
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception exc) {

        // Create CustomerErrorResponse
        CustomerErrorResponse errorResponse = new CustomerErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<CustomerErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
