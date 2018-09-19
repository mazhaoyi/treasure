package com.treasure.ssc.cons;

import java.math.BigDecimal;

/**
 * @author: mazy
 * @date: 2018/9/18 13:29
 */
public class SscConst {
    /**
     * 数据抓取地址
     */
    public static final String DATA_URL = "http://39.108.143.25:8080/stock/cqssc/getCurrentDay.sc";
    /**
     * 组三maxCount数字
     */
    public static final int MAX_COUNT_3 = 2;
    /**
     * 组三获奖倍数
     */
    public static final BigDecimal ZU_3_MULTIPLE = BigDecimal.valueOf(3.58888888);
}
