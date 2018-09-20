package com.treasure.ssc.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: mazy
 * @date: 2018/9/19 14:59
 */
public class SscUtils {
    /**
     * 前3字符串转换
     * @param str
     * @return
     */
    public static final String create3Before(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        return StringUtils.substring(str, 0, 3);
    }
    /**
     * 后3字符串转换
     * @param str
     * @return
     */
    public static final String create3After(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        return StringUtils.substring(str, 2, 5);
    }
    /**
     * 中3字符串转换
     * @param str
     * @return
     */
    public static final String create3Middle(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        return StringUtils.substring(str, 1, 4);
    }

    /**
     * 计算一个字符串中最大的重复数
     * @param str
     * @return
     */
    public static int maxCountChar(String str) {
        int res = 0;
        if (StringUtils.isBlank(str)) {
            return res;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int count = StringUtils.countMatches(str, c);
            if (count > res) {
                res = count;
            }
        }
        return res;
    }

    /**
     * 把数字转换成字符串，长度为size，如果长度不够，在前面补0
     * @param num 数字
     * @param length 长度
     * @return
     */
    public static final String frontZero(int num, int length) {
        return String.format("%0" + length + "d", num);
    }

}
