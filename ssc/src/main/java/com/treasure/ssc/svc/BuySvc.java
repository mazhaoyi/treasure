package com.treasure.ssc.svc;

import com.treasure.ssc.vo.SscVo;

import java.time.LocalDate;

/**
 * @author: mazy
 * @date: 2018/9/21 13:11
 */
public interface BuySvc {
    /**
     * 获取下一个号
     * @param no
     * @param date
     * @return
     */
    SscVo nextNo(LocalDate date, String no);


}
