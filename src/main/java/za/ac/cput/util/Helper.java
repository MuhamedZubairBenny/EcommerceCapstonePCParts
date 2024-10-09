package za.ac.cput.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty())
            return true;
        return false;
    }

    public static boolean isLessThanZero(int i){
        if(i==0)
            return true;
        return false;
    }

    public static boolean isLessZero(double d){
        if(d==0)
            return true;
        return false;
    }



    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    private static final AtomicLong counter = new AtomicLong(0);
    public static Long generateLongId() {
        return counter.incrementAndGet();
    }
    public static boolean emailIsValid(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
  
    public static boolean isNullOrZeroInt(Integer i) {
        return i == null || i == 0;
    }

    public static boolean isNullOrZeroDouble(Double value) {
        return value == null || value == 0.0;
    }
    public static Date isDateValid (String dateString, List<String> formatStrings) {
        for (String formatString : formatStrings) {
            try {
                return new SimpleDateFormat(formatString).parse(dateString);
            } catch (ParseException e) {
            }
        }
        return null;
    }

    public static List<String> getLocalDateFormats() {
        return Arrays.asList("dd/MM/yyyy", "yyyy-MM-dd");
    }
    public static <T> boolean isListEmpty(List<T> list) {
        return list == null || list.isEmpty();
    }
}
