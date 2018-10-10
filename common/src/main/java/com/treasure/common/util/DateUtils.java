package com.treasure.common.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author: mazy
 * @date: 2018/10/8 16:10
 */
public class DateUtils {
    /**
     * LocalDate -> Date
     * @param localDate
     * @return
     */
    public static Date toDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date -> LocalDate
     * @param date
     * @return
     */
    public static LocalDate toLocalDate(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
