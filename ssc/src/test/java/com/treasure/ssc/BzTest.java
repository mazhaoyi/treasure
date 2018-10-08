package com.treasure.ssc;

import com.treasure.ssc.svc.BzSvc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author: mazy
 * @date: 2018/10/8 14:56
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class BzTest {
    private static Logger logger = LoggerFactory.getLogger(BzTest.class);

    @Autowired
    private BzSvc bzSvc;

    @Test
    public void monthMoney() {
        LocalDate start = LocalDate.of(2018, 5, 1);
        LocalDate end = LocalDate.of(2018, 10, 1);
        while (start.isBefore(end)) {
            LocalDate tmpEnd = start.plusMonths(1);
            // 一个月的统计
            BigDecimal result = bzSvc.daysMoney(start, tmpEnd);
            logger.error("从 {} - {} ^^^^^^赚赔^^^^^ = {}", start, tmpEnd, result);
            start = tmpEnd;
        }
    }

    /**
     * 一段时间，豹子全买的情况下赚赔情况
     */
    @Test
    public void daysMoney() {
        LocalDate start = LocalDate.of(2018, 5, 1);
        LocalDate end = LocalDate.of(2018, 10, 1);
        BigDecimal result = bzSvc.daysMoney(start, end);
        logger.error("从 {} - {} ^^^^^^赚赔^^^^^ = {}", start, end, result);
    }

    /**
     * 每一天，豹子全买的情况下，赚赔情况
     */
    @Test
    public void daysSubMoney() {
        LocalDate start = LocalDate.of(2018, 5, 1);
        LocalDate end = LocalDate.of(2018, 10, 8);
        while (start.isBefore(end)) {
            // 一天
            BigDecimal result = bzSvc.oneDayMoney(start);
            if (result.compareTo(BigDecimal.ZERO) < 0) {
                logger.error("日期 = {} ^^^^^^^^^^^^^赔钱^^^^^^^^^^^^^ = {}", start, result);
            }
            start = start.plusDays(1);
        }
    }
}
