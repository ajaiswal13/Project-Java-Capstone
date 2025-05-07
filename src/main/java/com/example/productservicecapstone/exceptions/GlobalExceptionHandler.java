package com.example.productservicecapstone.exceptions;

import com.example.productservicecapstone.dtos.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//@RestControllerAdvice is a specialized version of @ControllerAdvice in Spring Framework, used to handle exceptions globally in a RESTful application. It's typically used in a class that defines methods to handle exceptions thrown by @RestController methods.
@RestControllerAdvice
public class GlobalExceptionHandler {

    //Using @ExceptionHandler(NullPointerException.class) inside a @RestControllerAdvice class allows you to globally catch and handle NullPointerException in your Spring Boot REST API.
    //Catches any NullPointerException thrown in your controllers
    //Returns a 400 Bad Request with a message
    @ExceptionHandler(NullPointerException.class)
    public ErrorDto handleNullPointerExceptions()
    {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setStatus("Failure");
        errorDto.setMessage("NullPointer exception occurred");

        return errorDto;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(
            ProductNotFoundException productNotFoundException)
    {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setStatus("Failure");
        errorDto.setMessage(productNotFoundException.getMessage());

        ResponseEntity<ErrorDto> responseEntity =
                new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);

        return responseEntity;
    }
}
