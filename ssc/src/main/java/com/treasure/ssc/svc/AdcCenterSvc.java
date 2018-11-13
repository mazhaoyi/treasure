package com.treasure.ssc.svc;

import com.treasure.ssc.vo.TicketSscVo;
import com.treasure.ssc.vo.adc.req.BuyReqVo;
import com.treasure.ssc.vo.adc.resp.AdcListVo;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 模拟中心服务
 * @author: mazy
 * @date: 2018/11/12 15:41
 */
public interface AdcCenterSvc {
    /**
     * 获取今天已经出了的期数列表
     * @return
     */
    AdcListVo nowList();
    /**
     * 获取下一期
     * @return
     */
    TicketSscVo nextNum();

    /**
     * 记录当前用户的玩到了那里
     * @param date
     * @param ticketNo
     */
    void recordUserNowNo(LocalDate date, String ticketNo);

    /**
     * 计算本期奖项
     * @param ticketId
     */
    void computeMoney(Integer ticketId, String ticketNum);

    /**
     * 购买一期
     * @param reqVo
     * @return 当前用户剩余金钱
     */
    BigDecimal buy(BuyReqVo reqVo);
}
