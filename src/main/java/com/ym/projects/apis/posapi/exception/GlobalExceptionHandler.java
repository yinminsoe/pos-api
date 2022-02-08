package com.ym.projects.apis.posapi.exception;

import com.ym.projects.apis.posapi.dto.ErrorCode;
import com.ym.projects.apis.posapi.dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleAllExceptions(Exception exception, WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("request_details",webRequest.getDescription(false));
        ErrorDto errorDto = ErrorDto.builder().details(errors).timestamp(LocalDateTime.now()).errorCode(ErrorCode.SE0001.toString()).message(exception.getMessage()).details(null).build();
        return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        errors.put("request_details",webRequest.getDescription(false));
        ErrorDto errorDto = ErrorDto.builder().details(errors).timestamp(LocalDateTime.now()).errorCode(ErrorCode.CE0001.toString()).message(exception.getMessage()).details(null).build();
        return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ErrorDto errorDto = ErrorDto.builder().timestamp(LocalDateTime.now()).errorCode(ErrorCode.CE0001.toString()).message(ex.getMessage()).details(errors).build();
        return new ResponseEntity(errorDto, HttpStatus.BAD_REQUEST);
    }
}
