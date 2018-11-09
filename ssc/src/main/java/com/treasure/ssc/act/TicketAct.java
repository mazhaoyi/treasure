package com.treasure.ssc.act;

import com.alibaba.fastjson.annotation.JSONField;
import com.treasure.common.util.ResultUtils;
import com.treasure.common.util.SscUtils;
import com.treasure.ssc.entity.BuyItem;
import com.treasure.ssc.svc.TicketSvc;
import com.treasure.ssc.vo.AnalyzeKlineVo;
import com.treasure.ssc.vo.SscOutVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
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
    /*@GetMapping("/dataToDb")
    public Object dataToDb() {
        // 最早2016-2-3，过年不开
        ticketSvc.dataToDb(LocalDate.of(2018, 11, 9), LocalDate.of(2018, 11, 9));
        return ResultUtils.success(null);
    }*/

    /// 不要删除
    /*@GetMapping(value = "/init")
    public Object initTicket() {
        ticketSvc.initTickets();
        return ResultUtils.success(null);
    }*/

    @GetMapping("/next")
    public Object next(String ticketNo, @JSONField(format = "yyyy-MM-dd") Date ticketDate) {
        if (!StringUtils.isNumeric(ticketNo)) {
            return ResultUtils.error("期数必须是数字！");
        }
        Integer noInt = Integer.valueOf(ticketNo);
        // 最大期数
        int maxNo = 120;
        if (noInt < 1) {
            return ResultUtils.error("必须是从1期开始！");
        }
        if (noInt > maxNo) {
            return ResultUtils.error(120, "最大期数为120！", null);
        }

        // 把no转换成3位数
        ticketNo = SscUtils.frontZero(noInt, 3);

        SscOutVo outVo = ticketSvc.next(ticketNo, ticketDate);
        return ResultUtils.success(outVo);
    }

    @GetMapping("/buy")
    public Object buy(String ticketNo, @JSONField(format = "yyyy-MM-dd") Date ticketDate, Short count, BigDecimal start) {
        if (!StringUtils.isNumeric(ticketNo)) {
            return ResultUtils.error("期数必须是数字！");
        }
        Integer noInt = Integer.valueOf(ticketNo);
        // 最大期数
        int maxNo = 120;
        if (noInt < 1) {
            return ResultUtils.error("必须是从1期开始！");
        }
        if (noInt > maxNo) {
            return ResultUtils.error(120, "最大期数为120！", null);
        }
        // 把no转换成3位数
        ticketNo = SscUtils.frontZero(noInt, 3);
        List<BuyItem> list = ticketSvc.buy(ticketNo, ticketDate, count, start);
        return ResultUtils.success(list);
    }

    @GetMapping("/kline")
    public Object kline(@JSONField(format = "yyyy-MM-dd") Date startDate, @JSONField(format = "yyyy-MM-dd") Date endDate) {
        List<AnalyzeKlineVo> results = ticketSvc.zu3KList(startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        return ResultUtils.success(results);
    }
}
