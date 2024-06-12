package com.shq.demo.javase.localDateTime;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LocalDateTimeTest {

    public static void main(String[] args) {
        String week = "2024-01-08";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String lastWeek = "";
        List<String> dayOfWeek = new ArrayList<>();
        try {
            Date date = format.parse(week);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
//            calendar.add(Calendar.DATE,1);
            calendar.add(Calendar.DATE,-7);
            lastWeek = format.format(calendar.getTime());
            calendar.add(Calendar.WEEK_OF_YEAR,1);
            for (int i = 0; i < 7; i++) {
                dayOfWeek.add(format.format(calendar.getTime()));
                calendar.add(Calendar.DATE,1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(lastWeek);
    }
}
