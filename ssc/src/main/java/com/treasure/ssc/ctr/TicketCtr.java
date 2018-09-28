package com.treasure.ssc.ctr;

import com.alibaba.fastjson.annotation.JSONField;
import com.treasure.ssc.svc.TicketSvc;
import com.treasure.ssc.util.ResUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: mazy
 * @date: 2018/9/28 15:23
 */
@RestController
@RequestMapping(value = "/ticketctr")
public class TicketCtr {
    @Autowired
    private TicketSvc ticketSvc;

    @GetMapping(value = "/init")
    public Object initTicket() {
        ticketSvc.initTickets();
        return ResUtils.success(null);
    }

    @GetMapping("/next")
    public Object buy(String ticketNo, @JSONField(format = "yyyy-MM-dd") Date ticketDate) {
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
    }
}
