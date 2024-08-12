package com.breakingbad.time;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.TimeZone;
/*
* java的日期和时间的api建议用 java.time 包下面的， java.util 包下面的 date 和 calendar 有些问题 */
public class testDate {
    @Test
    public void test1() throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String str3 = "1927-12-31 23:54:07";
        String str4 = "1927-12-31 23:54:08";
        System.out.println(sf.parse(str3).getTime()/1000);
        System.out.println(sf.parse(str4).getTime()/1000);
        System.out.println(sf.parse(str4).getTime()/1000 - sf.parse(str3).getTime()/1000 );
    }

    @Test
    public void test2(){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTimeString = "2023-12-31 23:54:07";
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, dateTimeFormatter);
        String formatted = localDateTime.format(dateTimeFormatter);
        System.out.println("Parsed LocalDateTime: " + formatted);
    }

}
