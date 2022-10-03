package com.marcos.saguier.msagecalc.entity;

/**
 * Represents an error
 */
public class ApiError {

    private Integer status;
    private String message;

    public ApiError() {
        //No-arg constructor
    }

    public ApiError(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
