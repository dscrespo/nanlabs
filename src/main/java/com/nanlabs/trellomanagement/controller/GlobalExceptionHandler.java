package com.nanlabs.trellomanagement.controller;

import com.nanlabs.trellomanagement.model.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleMissingArgument(Exception e){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder(status,e.getMessage())
                .withStackTrace(getStackTraceToString(e))
                .build();
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<ErrorResponse> handleNoType(Exception e){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder(status,e.getMessage())
                .withStackTrace(getStackTraceToString(e))
                .build();

        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullValue(Exception e){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder(status,e.getMessage())
                .withStackTrace(getStackTraceToString(e))
                .build();

        return new ResponseEntity<>(errorResponse, status);
    }

    private String getStackTraceToString(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        return sw.toString();
    }

}
