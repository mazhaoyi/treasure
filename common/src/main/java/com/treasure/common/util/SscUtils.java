package com.treasure.common.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
     * 查询一个字符串，每个字符在字符串中，重复的数目，去重，倒序
     * eg: str=aaabc 那么 return = [3, 1, 1];
     * @param str
     * @return
     */
    public static List<Integer> countChar(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int count = StringUtils.countMatches(str, c);
            list.add(count);
        }
        list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return list;
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

    /**
     * 判断012路
     * @param str
     * @return
     */
    public static final boolean check012(String str) {
        // 字符长度
        int length = 3;
        if (StringUtils.length(str) != length) {
            return false;
        }
        // 必须是数字
        if (!StringUtils.isNumeric(str)) {
            return false;
        }
        // 有0路
        boolean has0 = false;
        // 有1路
        boolean has1 = false;
        // 有2路
        boolean has2 = false;

        // 除数
        int divideNum = 3;
        for (char c : str.toCharArray()) {
            Integer cv = Integer.valueOf(String.valueOf(c));
            // int1 对3取余
            if (cv % divideNum == 0) {
                has0 = true;
            } else if (cv % divideNum == 1) {
                has1 = true;
            } else if (cv % divideNum == 2) {
                has2 = true;
            }
        }

        // 012路全有
        if (has0 && has1 && has2) {
            return true;
        }

        return false;
    }

    /**
     * 判断是否是组30
     * @param str
     * @return
     */
    public static final boolean checkZu30(String str) {
        // 字符长度
        int length = 5;
        // 如果长度!=5，就不是组30
        if (StringUtils.length(str) != length) {
            return false;
        }
        List<Integer> list = countChar(str);
        // [2, 2, 2, 2, 1]
        if (
            list.get(0) == 2
            && list.get(1) == 2
            && list.get(2) == 2
            && list.get(3) == 2
            && list.get(4) == 1
        ) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是组20
     * @param str
     * @return
     */
    public static final boolean checkZu20(String str) {
        // 字符长度
        int length = 5;
        // 如果长度!=5，就不是组20
        if (StringUtils.length(str) != length) {
            return false;
        }
        List<Integer> list = countChar(str);
        // [3, 3, 3, 1, 1]
        if (
            list.get(0) == 3
            && list.get(1) == 3
            && list.get(2) == 3
            && list.get(3) == 1
            && list.get(4) == 1
        ) {
            return true;
        }
        return false;
    }

    public static final boolean checkZu10(String str) {
        // 字符长度
        int length = 5;
        // 如果长度!=5，就不是组10
        if (StringUtils.length(str) != length) {
            return false;
        }
        List<Integer> list = countChar(str);
        // [3, 3, 3, 2, 2]
        if (
            list.get(0) == 3
            && list.get(1) == 3
            && list.get(2) == 3
            && list.get(3) == 2
            && list.get(4) == 2
        ) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是组5
     * @param str
     * @return
     */
    public static final boolean checkZu5(String str) {
        // 字符长度
        int length = 5;
        // 如果长度!=5，就不是组5
        if (StringUtils.length(str) != length) {
            return false;
        }
        List<Integer> list = countChar(str);
        // [4, 4, 4, 4, 1]
        if (
            list.get(0) == 4
            && list.get(1) == 4
            && list.get(2) == 4
            && list.get(3) == 4
            && list.get(4) == 1
        ) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "12345";
        System.out.println(str);
        System.out.println(SscUtils.checkZu30(str) + "组30");
        System.out.println(SscUtils.checkZu20(str) + "组20");
        System.out.println(SscUtils.checkZu10(str) + "组10");
        System.out.println(SscUtils.checkZu5(str) + "组5");
    }

}
