package com.example.snmptrapreceiver.util;



import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 时间日期工具类
 */
public class DateTimeUtil {

    public static final String YEAR_FORMAT = "yyyy";
    public static final String YEAR_MONTH_FORMAT = "yyyy-MM";
    public static final String YEAR_MONTH_DAY_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_MILLISECOND_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String MONTH_FORMAT_STR = "yyyyMM";
    public static final String DAY_FORMAT_STR = "yyyyMMdd";
    public static final String MINITE_FORMAT_STR = "yyyyMMddHHmm";
    public static final String DEFAULT_FORMAT_STR = "yyyyMMddHHmmss";
    public static final String DEFAULT_FORMAT_STR_SSS = "yyyyMMddHHmmssSSS";
    private static ZoneId zoneId = ZoneId.systemDefault();
    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_FORMAT);
    public static final int WEEK = 6;
    public static final int MONTH = 5;
    public static final int DAY = 4;
    public static final int HOUR = 3;
    public static final int MINUTE = 2;
    public static final int SECOND = 1;
    public static final int YEAR = 7;
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    public static Date now() {
        return Date.from(LocalDateTime.now().atZone(zoneId).toInstant());
    }

    public static String nowStr() {
        return dateToStr(now(), DEFAULT_FORMAT);
    }

    public static String nowStr(String format) {
        if (StringUtils.isEmpty(format)) {
            format = DEFAULT_FORMAT;
        }
        return dateToStr(now(), format);
    }

    public static String dateToStr(Date date) {
        return dateToStr(date, DEFAULT_FORMAT);
    }

    public static String dateToStr(Date date, String format) {
        if (date == null || StringUtils.isEmpty(format)) {
            return StringUtils.EMPTY;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return dtf.format(dateToLocalDateTime(date));
    }

    public static Date strToDate(String dateStr) {
        return strToDate(dateStr.replaceAll("T", " "), DEFAULT_FORMAT);
    }

    /**
     * 该方法无法区分yyyyMMd和yyyyMMdd
     * 弃用
     *
     * @param dateStr
     * @param format
     */
    /*public static Date strToDate(String dateStr, String format) {
        return StringUtils.isEmpty(dateStr) ? null : localDateTimeToDate(LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(format)));
    }*/
    public static Date strToDate(String dateStr, String format) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return date.toInstant().atZone(zoneId).toLocalDateTime();
    }

    //根据一个时间差返回计算的时间
    public static Date reckonDate(Date dateTime, int num) {
        Calendar calendar = Calendar.getInstance();
        Date endTime = new Date();
        calendar.setTime(dateTime);
        calendar.add(Calendar.DATE, num);
        endTime = calendar.getTime();
        return endTime;
    }

    //判断两个时间间隔的天数
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        smdate = simpleDateFormat.parse(simpleDateFormat.format(smdate));
        bdate = simpleDateFormat.parse(simpleDateFormat.format(bdate));
        return (int) ((bdate.getTime() - smdate.getTime()) / (60 * 60 * 24 * 1000));
    }

    //判断两个时间间隔的天数
    public static int minutesBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        smdate = simpleDateFormat.parse(simpleDateFormat.format(smdate));
        bdate = simpleDateFormat.parse(simpleDateFormat.format(bdate));
        return (int) ((bdate.getTime() - smdate.getTime()) / (60 * 1000));
    }

    public static String formatEsDate(Date date) throws Exception {
        return dateFormat.format(date) + "T" + timeFormat.format(date);
    }

    public static String dateFormat(Date date) throws Exception {
        return dateFormat.format(date);
    }

    public static String timFormat(Date date) throws Exception {
        return timeFormat.format(date);
    }

    public static String simpleFormat(Date date) throws Exception {
        return dateFormat.format(date) + " " + timeFormat.format(date);
    }

    public static Date dateGet(Date date, int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (field == SECOND) {
            calendar.add(Calendar.SECOND, amount);
        } else if (field == MINUTE) {
            calendar.add(Calendar.MINUTE, amount);
        } else if (field == HOUR) {
            calendar.add(Calendar.HOUR, amount);
        } else if (field == DAY) {
            calendar.add(Calendar.DAY_OF_YEAR, amount);
        } else if (field == MONTH) {
            calendar.add(Calendar.MONTH, amount);
        } else if (field == WEEK) {
            calendar.add(Calendar.WEEK_OF_YEAR, amount);
        } else if (field == YEAR) {
            calendar.add(Calendar.YEAR, amount);
        }
        return calendar.getTime();
    }

    public static String formatEsDate(String simpleDate) {
        return simpleDate.replace(" ", "T");
    }

    public static Date addDays(Date date, int days) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);//往上推一天(-1)  30推三十天  365推一年
        date = calendar.getTime();
        return date;
    }

    public static Date addMonth(Date date, int num) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, num);
        date = calendar.getTime();
        return date;
    }

    public static Date addMinutes(Date date, int num) {
        if (date == null) {
            date = new Date();
        }
        date.setTime(date.getTime() + num * 60 * 1000L);
        return date;
    }

    /**
     * @param Time1 时间
     * @param Time2 时间
     * @return 两个时间段内的随机时间
     */
    public static String getTimeRandom(Date Time1, Date Time2) {
        Calendar cTime1 = Calendar.getInstance();
        Calendar cTime2 = Calendar.getInstance();
        cTime1.setTime(Time1);
        cTime2.setTime(Time2);
        long time1SS = cTime1.getTimeInMillis() / 1000L;
        long time2SS = cTime2.getTimeInMillis() / 1000L;
        Random random = new Random();
        double randomDoubleNum = random.nextDouble();
        double d;
        long longNewTime;
        if (time1SS < time2SS) {
            d = (double) (time2SS - time1SS) * randomDoubleNum;
            longNewTime = time1SS + (long) d;
        } else {
            d = (double) (time1SS - time2SS) * randomDoubleNum;
            longNewTime = time2SS + (long) d;
        }

        Calendar cNewTime = Calendar.getInstance();
        cNewTime.setTimeInMillis(longNewTime * 1000L);
        return dateTimeFormatter.format(cNewTime.getTime().toInstant());
    }

    /**
     * @param dt1 时间
     * @param dt2 时间
     * @return 两个时间的月份差，返回绝对值，不区分时间大小
     */
    public static int monthDiff(LocalDateTime dt1, LocalDateTime dt2) {
        boolean before = dt1.isBefore(dt2);
        int month1;
        int year1;
        int month2;
        int year2;
        if (before) {
            month1 = dt1.getMonthValue();
            year1 = dt1.getYear();
            month2 = dt2.getMonthValue();
            year2 = dt2.getYear();
        } else {
            month1 = dt2.getMonthValue();
            year1 = dt2.getYear();
            month2 = dt1.getMonthValue();
            year2 = dt1.getYear();
        }
        return (year2 - year1) * 12 + (month2 - month1);
    }

    /**
     * @param dt1 时间
     * @param dt2 时间
     * @return 两个时间的年份差，返回绝对值，不区分时间大小
     */
    public static int yearDiff(LocalDateTime dt1, LocalDateTime dt2) {
        int year1 = dt1.getYear();
        int year2 = dt2.getYear();
        return Math.abs(year2 - year1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.err.println(strToDate("2020-12-9 08:53:11"));
        }
    }
}
