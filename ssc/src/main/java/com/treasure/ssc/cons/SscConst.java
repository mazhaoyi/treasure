package com.treasure.ssc.cons;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    /**
     * 购买目录
     */
    public static final Path BUY_DIR = Paths.get("E:", "files3", "buydata");
    /**
     * 金钱文件
     */
    public static final Path MONEY_DIR = Paths.get("E:", "files3", "moneydata");
    /**
     * 源文件目录
     */
    public static final Path SOURCE_DIR = Paths.get("E:", "files3", "sourcedata");
}
