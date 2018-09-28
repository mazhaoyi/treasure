package com.treasure.ssc.ctr;

import com.treasure.ssc.svc.TicketSvc;
import com.treasure.ssc.util.ResUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
