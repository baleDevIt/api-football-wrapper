package it.gbale.apisports.utils;

public class Validation {

    public static void _assertNotNull(Object paramName) {
        if (paramName == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", paramName.getClass().getName()));
        }
    }

    public static void _assertNotNull(Object... paramName) {
        for (Object param: paramName) {
            _assertNotNull(param);
        }
    }

    public static void _assertNotNullorEmpty(String paramName) {
        if (paramName == null || paramName.trim().equalsIgnoreCase("")) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null or empty", paramName));
        }
    }

    public static void _assertNotNullorEmpty(String... paramName) {
        for (String param : paramName) {
            _assertNotNullorEmpty(param);
        }
    }

    public static void _assertHaveEqualOrMoreCharacters(String paramName, int characters) {
        if (paramName == null || paramName.trim().length() < characters) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null or empty", paramName));
        }
    }

    public static void _assertHaveEqualCharacters(String paramName, int characters) {
        if (paramName == null || paramName.trim().length() != characters) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null or empty", paramName));
        }
    }

    public static boolean _isNotNullorEmpty(String paramName) {
        if (paramName == null || paramName.trim().equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }

    public static boolean _isNotNull(Object paramName) {
        if (paramName == null) {
            return false;
        }
        return true;
    }
}
