package com.eazybytes.accounts.exception;


import com.eazybytes.accounts.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles all the unhandled exceptions and returns a HTTP response with status code 500
     * and an {@link ErrorResponseDto} in the body. The DTO contains the exception message and the current time.
     *
     * @param exception The exception to handle
     * @param webRequest The current web request
     * @return A ResponseEntity containing an ErrorResponseDto
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception,
                                                                                WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles the exception {@link CustomerAlreadyExitsException} and returns a HTTP response with status code 400
     * and an {@link ErrorResponseDto} in the body. The DTO contains the exception message and the current time.
     *
     * @param exception The exception to handle
     * @param webRequest The current web request
     * @return A ResponseEntity containing an ErrorResponseDto
     */
    @ExceptionHandler(CustomerAlreadyExitsException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExitsException(CustomerAlreadyExitsException exception,
                                                                                WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }


    /**
     * Handles the exception {@link ResourceNotFoundException} and returns a HTTP response with status code 404
     * and an {@link ErrorResponseDto} in the body. The DTO contains the exception message and the current time.
     *
     * @param exception The exception to handle
     * @param webRequest The current web request
     * @return A ResponseEntity containing an ErrorResponseDto
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                                WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }


}
