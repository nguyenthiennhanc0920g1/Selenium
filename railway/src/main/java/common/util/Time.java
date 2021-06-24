package common.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.sql.Date;

public class Time {
    public static String increaseOrDecreaseDay(String dateFormat, String stringDate, int increaseOrDecreaseNumber) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        Date date = Date.valueOf(stringDate);
        calendar.setTime(date);
        calendar.add(Calendar.DATE, increaseOrDecreaseNumber);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static void waitLoadContent(int milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getCurrentTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        LocalDateTime currentTime = LocalDateTime.now();
        return dateTimeFormatter.format(currentTime);
    }
}
