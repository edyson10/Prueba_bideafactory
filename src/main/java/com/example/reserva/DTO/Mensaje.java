package com.example.reserva.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mensaje {

    @JsonProperty("statusCode")
    private int statusCode;
    @JsonProperty("error")
    private String error;
    @JsonProperty("message")
    private String message;

    public Mensaje(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Mensaje(int statusCode, String error, String message) {
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
