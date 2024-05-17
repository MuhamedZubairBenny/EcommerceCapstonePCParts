package za.ac.cput.util;

import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty())
            return true;
        return false;
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean emailIsValid(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
    public static boolean isNullOrZero(Integer i) {
        return i == null || i == 0;
    }

    public static boolean isNullOrZero(Double value) {
        return value == null || value == 0.0;
    }

}
