package com.treasure.ssc.converter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

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
        Date date = null;
        try {
            String[] parsePatterns = {
                    "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy-MM-dd HH:mm",
                    "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm",
                    "yyyyMMdd"
            };
            date = DateUtils.parseDate(s, parsePatterns);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static void main(String[] args) {
        try {
            String[] parsePatterns = {
                    "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy-MM-dd HH:mm",
                    "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm",
                    "yyyyMMdd"
            };
            System.out.println(DateUtils.parseDate("2009/09/01 10:10:10", parsePatterns));
            System.out.println(DateUtils.parseDate("2009/9/1 10:10:10", parsePatterns));
            System.out.println(DateUtils.parseDate("20090901", parsePatterns));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
