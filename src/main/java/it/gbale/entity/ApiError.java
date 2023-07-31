package it.gbale.entity;

public class ApiError {
    private String message;

    public ApiError() {
        super();
        this.message = "Generic Error - I don't know what happened!";
    }

    public ApiError(String message) {
        this.message = message;
    }
}
