package com.treasure.ssc.converter;

import javafx.scene.input.DataFormat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * 字符串转日期
 * @author: mazy
 * @date: 2018/5/25 15:51
 */
public class String2DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        if (StringUtils.isBlank(s)) {
            return null;
        }
        DateFormat dateFormat;
        switch (s.length()){
            case 10:
                dateFormat = DateFormat.getDateInstance();
                break;
            case 19:
                dateFormat = DateFormat.getDateTimeInstance();
                break;
            default:
                dateFormat = DateFormat.getDateInstance();
        }

        Date date = null;
        try {
            date = dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static void main(String[] args) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        try {
            Date date = dateFormat.parse("2018-09-17 00:00:01");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
