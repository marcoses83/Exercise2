package com.spotahome.test.framework;

import java.time.LocalDate;
import java.util.Random;

public class DateRandomizer {
    public static LocalDate randomDate(LocalDate start) {
        final int MAX_DATE_RANGE_IN_DAYS = 365 * 10;
        final int MIN_DATE_RANGE_IN_DAYS = 30;
        int daysToAdd = new Random().ints(MIN_DATE_RANGE_IN_DAYS, MAX_DATE_RANGE_IN_DAYS + 1).findFirst().getAsInt();
        return start.plusDays(daysToAdd);
    }

    public static LocalDate randomDate(LocalDate start, LocalDate end) {
        int daysToAdd = (int)new Random().longs(0, end.toEpochDay() - start.toEpochDay() + 1).findFirst().getAsLong();
        return start.plusDays(daysToAdd);
    }

    public static LocalDate randomDate(LocalDate start, int minStay, int maxStay) {
        int daysToAdd = new Random().ints(minStay, maxStay + 1).findFirst().getAsInt();
        return start.plusDays(daysToAdd);
    }
}
