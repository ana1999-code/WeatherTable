package org.example.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String nextDay() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        return tomorrow.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
