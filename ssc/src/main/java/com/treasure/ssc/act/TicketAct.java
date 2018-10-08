package com.treasure.ssc.act;

import com.alibaba.fastjson.annotation.JSONField;
import com.treasure.ssc.entity.BuyItem;
import com.treasure.ssc.svc.TicketSvc;
import com.treasure.ssc.util.ResUtils;
import com.treasure.ssc.util.SscUtils;
import com.treasure.ssc.vo.SscOutVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: mazy
 * @date: 2018/9/28 15:23
 */
@RestController
@RequestMapping(value = "/ticketctr")
public class TicketAct {
    @Autowired
    private TicketSvc ticketSvc;

    /// 不要删除
    /*@GetMapping(value = "/init")
    public Object initTicket() {
        ticketSvc.initTickets();
        return ResUtils.success(null);
    }*/

    @GetMapping("/next")
    public Object next(String ticketNo, @JSONField(format = "yyyy-MM-dd") Date ticketDate) {
        if (!StringUtils.isNumeric(ticketNo)) {
            return ResUtils.error("期数必须是数字！");
        }
        Integer noInt = Integer.valueOf(ticketNo);
        // 最大期数
        int maxNo = 120;
        if (noInt < 1) {
            return ResUtils.error("必须是从1期开始！");
        }
        if (noInt > maxNo) {
            return ResUtils.error(120, "最大期数为120！", null);
        }

        // 把no转换成3位数
        ticketNo = SscUtils.frontZero(noInt, 3);

        SscOutVo outVo = ticketSvc.next(ticketNo, ticketDate);
        return ResUtils.success(outVo);
    }

    @GetMapping("/buy")
    public Object buy(String ticketNo, @JSONField(format = "yyyy-MM-dd") Date ticketDate, Short count, BigDecimal start) {
        if (!StringUtils.isNumeric(ticketNo)) {
            return ResUtils.error("期数必须是数字！");
        }
        Integer noInt = Integer.valueOf(ticketNo);
        // 最大期数
        int maxNo = 120;
        if (noInt < 1) {
            return ResUtils.error("必须是从1期开始！");
        }
        if (noInt > maxNo) {
            return ResUtils.error(120, "最大期数为120！", null);
        }
        // 把no转换成3位数
        ticketNo = SscUtils.frontZero(noInt, 3);
        List<BuyItem> list = ticketSvc.buy(ticketNo, ticketDate, count, start);
        return ResUtils.success(list);
    }
}
