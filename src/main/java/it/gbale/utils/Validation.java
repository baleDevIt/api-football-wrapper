package it.gbale.utils;

public class Validation {

    public static final void _assertNotNull(String paramName) {
        if (paramName == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", paramName));
        }
    }

    public static final void _assertNotNullorEmpty(String paramName) {
        if (paramName == null || paramName.trim().equalsIgnoreCase("")) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null or empty", paramName));
        }
    }
}
