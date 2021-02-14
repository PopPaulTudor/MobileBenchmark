package com.example.benchmark.utills;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {

    public static String milliToDate(long date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");
        dateFormat.setTimeZone(calendar.getTimeZone());

        return dateFormat.format(calendar.getTime());
    }


    public static long StartToHour(long start) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(start);

        return calendar.get(Calendar.HOUR_OF_DAY) * 3600000 + calendar.get(Calendar.MINUTE) * 60000;
    }

    public static long setHourTo24(long date) {

        Calendar aux = Calendar.getInstance();
        aux.setTimeInMillis(date);
        aux.set(Calendar.HOUR, 0);
        aux.set(Calendar.MINUTE, 0);
        aux.set(Calendar.SECOND, 0);
        aux.set(Calendar.MILLISECOND, 0);
        aux.set(Calendar.HOUR_OF_DAY, 0);


        return aux.getTimeInMillis();

    }
}
