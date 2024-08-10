package com.shm.consumer.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

  public static Date getNowWithDatasetTimestamp(String timestampStr) throws ParseException {
    Date originalDate;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    originalDate = dateFormat.parse(timestampStr);

    // Get the current date and time
    Calendar now = Calendar.getInstance();

    // Create a Calendar object with the original date
    Calendar originalCalendar = Calendar.getInstance();
    originalCalendar.setTime(originalDate);

    // Update the original Calendar with the current year, month, day, hour, and minute
    originalCalendar.set(Calendar.YEAR, now.get(Calendar.YEAR));
    originalCalendar.set(Calendar.MONTH, now.get(Calendar.MONTH));
    originalCalendar.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH));
    originalCalendar.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY));
    originalCalendar.set(Calendar.MINUTE, now.get(Calendar.MINUTE));
    // Keep the original seconds as they are

    // Convert back to Date

    return originalCalendar.getTime();
  }
}
