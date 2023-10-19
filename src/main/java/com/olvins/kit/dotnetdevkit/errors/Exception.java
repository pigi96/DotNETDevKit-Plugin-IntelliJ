package com.olvins.kit.dotnetdevkit.errors;

public class Exception extends RuntimeException {
    public String message;
    public String details;
    public String code;

    public Exception(String message, String details, String code) {
        this.message = message;
        this.details = details;
        this.code = code;
    }

    public Exception(String message, String details) {
        this.message = message;
        this.details = details;
    }

    public Exception(String message) {
        this.message = message;
    }
}
