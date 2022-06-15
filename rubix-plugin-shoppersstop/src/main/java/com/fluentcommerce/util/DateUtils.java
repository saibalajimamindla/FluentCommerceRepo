package com.fluentcommerce.util;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
public final class DateUtils {

    private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private DateUtils() {}

    public static int getHour(Integer openingHour) {
        return openingHour / 100;
    }

    public static int getMinute(Integer openingHour) {
        return openingHour % 100;
    }

    public static String formatOpeningHours(String startTimeStr, String endTimeStr) {
        int startTime = Integer.parseInt(startTimeStr);
        int endTime = Integer.parseInt(endTimeStr);

        if (isStoreClosed(startTime, endTime)) {
            return "Closed";
        }
        if (isStoreOpen24(startTime, endTime)) {
            return "24 Hours";
        }

        return getFormattedTime(startTime) + " - " + getFormattedTime(endTime);
    }

    public static String getFormattedTime(int time) {
        int hour = getHour(time);
        int minute = getMinute(time);

        if (hour == 0) {
            return "Midnight";
        }
        if (hour > 12) {
            return hour % 12 + ":" + String.format("%02d", minute) + "pm";
        }
        return hour + ":" + String.format("%02d", minute) + "am";

    }

    public static boolean isStoreClosed(int startTime, int endTime) {
        return (startTime == 1 && endTime == 1) || (startTime == -1 && endTime == -1);
    }

    public static boolean isStoreOpen24(int startTime, int endTime) {
        return startTime == 0 && endTime == 0;
    }


    public static String formatDateTime(Date dateToConvert, ZoneId zoneId) {
        LocalDateTime localDateTime = dateToConvert.toInstant()
            .atZone(zoneId)
            .toLocalDateTime();
        return localDateTime.format(FORMATTER);
    }
}
