package it.gbale.apisports.apifootball.model.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiError extends RuntimeException {
    @JsonProperty("message")
    private String message;

    public ApiError() {
        super();
    }

    public ApiError(String message) {
        this.message = message;
    }
}
