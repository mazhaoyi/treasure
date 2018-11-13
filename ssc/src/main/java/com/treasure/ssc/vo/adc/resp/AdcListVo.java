package com.treasure.ssc.vo.adc.resp;

import com.treasure.ssc.vo.TicketSscVo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author: mazy
 * @date: 2018/11/13 13:57
 */
public class AdcListVo implements Serializable {
    private static final long serialVersionUID = 7096777584467385557L;
    private List<TicketSscVo> ticketSscVos;
    private BigDecimal nowMoney;

    public List<TicketSscVo> getTicketSscVos() {
        return this.ticketSscVos;
    }

    public void setTicketSscVos(List<TicketSscVo> ticketSscVos) {
        this.ticketSscVos = ticketSscVos;
    }

    public BigDecimal getNowMoney() {
        return this.nowMoney;
    }

    public void setNowMoney(BigDecimal nowMoney) {
        this.nowMoney = nowMoney;
    }
}
