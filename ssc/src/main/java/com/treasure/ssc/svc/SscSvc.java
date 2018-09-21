package com.treasure.ssc.svc;

import com.treasure.ssc.vo.SscVo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author: mazy
 * @date: 2018/9/18 13:31
 */
public interface SscSvc {
    /**
     * 查询某天的数据
     * @param date
     * @return
     */
    List<SscVo> list(LocalDate date);

    /**
     * 计算列表中的数据
     * @param list
     * @return
     */
    List<SscVo> reduceList(List<SscVo> list);

    /**
     * 1,2算法计算一天的钱
     * @param list 一天列表
     * @param countMoney 总钱数
     * @param startMoney 1的钱
     * @return
     */
    BigDecimal reduceMoney12OneDay(List<SscVo> list, BigDecimal countMoney, BigDecimal startMoney);
}
