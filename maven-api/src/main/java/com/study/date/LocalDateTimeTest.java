package com.study.date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        Date from = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(from);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = now.format(dateTimeFormatter);
        System.out.println(date);

        LocalDateTime parse = LocalDateTime.parse("2008-08-01 11:20:21",dateTimeFormatter);
        System.out.println(parse);

        Instant instant = new Date().toInstant();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime);

        System.out.println(localDateTime.withDayOfMonth(1));
        System.out.println(localDateTime.withDayOfYear(1));
//        System.out.println(localDateTime);

        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());

        System.out.println(localDateTime.plusMonths(1));
        System.out.println(localDateTime.plusDays(1));

        System.err.println(localDateTime.minusYears(2));


    }

    @Test
    public void  test(){

        //Duration 比较的是两个时间之间的间隔
        //period 日期间隔

        //时间矫正器
        LocalDateTime with = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        LocalDateTime with1 = LocalDateTime.now().with(e -> {
            LocalDateTime localDateTime = (LocalDateTime) e;
            return localDateTime.plusMonths(1);
        });

        System.out.println(with1);




    }
}
