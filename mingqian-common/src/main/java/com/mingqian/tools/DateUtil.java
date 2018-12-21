package com.mingqian.tools;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class DateUtil {

    public static final String FORMAT1 = "yyyy-MM-dd";
    public static final String FORMAT2 = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT3 = "yyyy/MM/dd";
    public static final String FORMAT4 = "yyyy/MM/dd HH:mm:ss";
    public static final String FORMAT5 = "yyyy-MM-dd HH:mm:ss SSS";
    public static final String FORMAT6 = "yyyyMMddHHmmssSSS";
    public static final String FORMAT7 = "yyyyMMdd";
    public static final String FORMAT8 = "yyyyMMddHHmmss";
    public static final String FORMAT9 = "dd MMMM yyyy";
    public static final String FORMAT10 = "HH:mm";

    public static String getDateString(Long second, String DATE_PATTERN) {
        return format(second.longValue() * 1000L, DATE_PATTERN);
    }

    public static String getLocalDateTime(String DATE_PATTERN){
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern(DATE_PATTERN).withLocale(Locale.CHINESE));
    }

    public static String getEnglishDateString(Long second, String DATE_PATTERN) {
        ZonedDateTime localDateTime = ZonedDateTime.ofInstant(Instant.ofEpochSecond(second.longValue()), ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(DATE_PATTERN).withLocale(Locale.ENGLISH));
    }

    public static long toSecond(String dateFormatStr, String DATE_PATTERN) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateFormatStr, DateTimeFormatter.ofPattern(DATE_PATTERN));
        return localDateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    public static long toSecond() {
        return LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    public static Date parseDateTime(String str, String formatPattern) {
        LocalDateTime dateTime = LocalDateTime.parse(str, DateTimeFormatter.ofPattern(formatPattern));
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date parseDate(String str, String formatPattern) {
        LocalDate dateTime = LocalDate.parse(str, DateTimeFormatter.ofPattern(formatPattern));
        return Date.from(dateTime.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static String format(Date date, String formatPattern) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(formatPattern));
    }

    public static String format(long dateMillis, String formatPattern) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(dateMillis), ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(formatPattern));
    }

    public static boolean isWeekEnd(Date date) {
        LocalDate localDate = LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault()));
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();


        return (DayOfWeek.SUNDAY.getValue() == dayOfWeek.getValue()) || (DayOfWeek.SATURDAY.getValue() == dayOfWeek.getValue());
    }

    public static WeekOfYear getWeekOfYear(Date date, int minimalDaysInFirstWeek) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.setFirstDayOfWeek(2);
        c.setMinimalDaysInFirstWeek(minimalDaysInFirstWeek);
        int weekOfWeekyear = c.get(3);
        WeekOfYear weekOfYear = new WeekOfYear();
        weekOfYear.setWeekOfYear(weekOfWeekyear);
        if ((52 == weekOfWeekyear) || (53 == weekOfWeekyear)) {
            int month = c.get(2);
            if (0 == month) {
                weekOfYear.setThisYear(false);
            }
        }
        return weekOfYear;
    }

    public static int getDayOfWeek(Date date) {
        LocalDate localDate = LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault()));
        return localDate.getDayOfWeek().getValue();
    }

    public static int getYear(Date date) {
        LocalDate localDate = LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault()));
        return localDate.getYear();
    }

    public static int getMonth(Date date) {
        LocalDate localDate = LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault()));
        return localDate.getMonthValue();
    }

    public static int getDay(Date date) {
        LocalDate localDate = LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault()));
        return localDate.getDayOfMonth();
    }

    public static int getHour(Date date) {
        LocalTime localTime = LocalTime.from(date.toInstant().atZone(ZoneId.systemDefault()));
        return localTime.getHour();
    }

    public static int getMinute(Date date) {
        LocalTime localTime = LocalTime.from(date.toInstant().atZone(ZoneId.systemDefault()));
        return localTime.getMinute();
    }

    public static int getSecond(Date date) {
        LocalTime localTime = LocalTime.from(date.toInstant().atZone(ZoneId.systemDefault()));
        return localTime.getSecond();
    }

    public static int getQuarter(Date date) {
        LocalDate localDate = LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault()));
        Double dd = Double.valueOf(Math.floor((localDate.getMonthValue() - 1) / 3.0D));
        return dd.intValue() + 1;
    }

    public static boolean leapYear(int year) {
        LocalDate date = LocalDate.ofYearDay(year, 1);
        return date.isLeapYear();
    }

    public static int daysBetween(Date smdate, Date bdate) {
        Duration duration = Duration.between(smdate.toInstant(), bdate.toInstant());
        return Long.valueOf(duration.toDays()).intValue();
    }

    public static Date addMonth(Date startDate,int monthNum){
        LocalDateTime localDateTime = LocalDateTime.ofInstant(startDate.toInstant(),ZoneId.systemDefault());
        LocalDateTime plus = localDateTime.plus(monthNum, ChronoUnit.MONTHS);
        ZonedDateTime zonedDateTime = plus.atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    public static int absDaysBetween(Date smdate, Date bdate) {
        return Math.abs(daysBetween(smdate, bdate));
    }

    public static Date addDay(Date startDate, long num) {
        LocalDateTime localDateTime = LocalDateTime.from(startDate.toInstant().atZone(ZoneId.systemDefault()));
        LocalDateTime newDate = localDateTime.plusDays(num);
        return Date.from(newDate.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static class WeekOfYear {
        private boolean thisYear = true;
        private int weekOfYear = 0;

        public boolean isThisYear() {
            return this.thisYear;
        }

        public void setThisYear(boolean thisYear) {
            this.thisYear = thisYear;
        }

        public int getWeekOfYear() {
            return this.weekOfYear;
        }

        public void setWeekOfYear(int weekOfYear) {
            this.weekOfYear = weekOfYear;
        }
    }

}
