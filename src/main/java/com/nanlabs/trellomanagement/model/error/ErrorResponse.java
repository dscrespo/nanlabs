package com.nanlabs.trellomanagement.model.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public class ErrorResponse {

    // customizing timestamp serialization format
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    private int code;

    private String status;

    private String message;

    private String stackTrace;

    public Date getTimestamp() {
        return timestamp;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public ErrorResponse() {
        timestamp = new Date();
    }

    private ErrorResponse(ErrorResponseBuilder builder) {
        this();
        this.code = builder.code;
        this.status = builder.status;
        this.message = builder.message;
        this.stackTrace = builder.stackTrace;
    }

    public static class ErrorResponseBuilder {
        private int code;
        private String status;
        private String message;
        private String stackTrace;

        public ErrorResponseBuilder(HttpStatus httpStatus, String message) {
            this.code = httpStatus.value();
            this.status = httpStatus.name();
            this.message = message;
            this.stackTrace = "";
        }

        public ErrorResponseBuilder withStackTrace(String stackTrace){
            this.stackTrace = stackTrace;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this);
        }
    }
}
