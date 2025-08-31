package org.example.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class DateUtilTest {

    @Test
    public void TestNextDate() {
        String expectedTomorrow = LocalDate.now().plusDays(1)
                .format(DateTimeFormatter.ISO_LOCAL_DATE);
        String actualTomorrow = DateUtil.nextDay();

        Assertions.assertEquals(expectedTomorrow, actualTomorrow);
    }

}