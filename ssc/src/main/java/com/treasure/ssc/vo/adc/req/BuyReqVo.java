package com.treasure.ssc.vo.adc.req;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: mazy
 * @date: 2018/11/12 15:45
 */
public class BuyReqVo implements Serializable {
    private static final long serialVersionUID = -6331867832512956725L;
    /**
     * 购买额度
     */
    private BigDecimal buyMoney;

    public BigDecimal getBuyMoney() {
        return this.buyMoney;
    }

    public void setBuyMoney(BigDecimal buyMoney) {
        this.buyMoney = buyMoney;
    }
}
