package com.treasure.ssc.svc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author: mazy
 * @date: 2018/10/8 12:16
 */
public interface BzSvc {
    /**
     * 初始化数据到豹子
     */
    void initBz();

    /**
     * 按照天来计算，全买的情况下赚赔情况
     * @param date
     * @return
     */
    BigDecimal oneDayMoney(LocalDate date);

    /**
     * 获取一段时间，全买豹子的赚赔情况
     * @param start
     * @param end
     * @return
     */
    BigDecimal daysMoney(LocalDate start, LocalDate end);
}
