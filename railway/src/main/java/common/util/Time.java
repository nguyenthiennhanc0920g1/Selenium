package common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

public class Time {
    public static String IncreaseOrDecreaseDay(String dateFormat, String stringDate, int increaseOrDecreaseNumber) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        Date date = Date.valueOf(stringDate);
        calendar.setTime(date);
        calendar.add(Calendar.DATE, increaseOrDecreaseNumber);
        return simpleDateFormat.format(calendar.getTime());
    }
}
