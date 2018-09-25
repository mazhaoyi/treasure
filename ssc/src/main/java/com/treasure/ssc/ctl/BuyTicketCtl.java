package com.treasure.ssc.ctl;

import com.alibaba.fastjson.annotation.JSONField;
import com.treasure.ssc.svc.BuySvc;
import com.treasure.ssc.util.ResUtils;
import com.treasure.ssc.util.SscUtils;
import com.treasure.ssc.vo.SscVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.Date;

/**
 * @author: mazy
 * @date: 2018/9/21 12:19
 */
@RestController
@RequestMapping(value = "/buy")
public class BuyTicketCtl {
    @Autowired
    private BuySvc buySvc;

    @GetMapping(value = "/nextno")
    public Object nextNo(String no, @JSONField(format = "yyyy-MM-dd") Date date) {
        if (!StringUtils.isNumeric(no)) {
            return ResUtils.error("期数必须是数字！");
        }
        Integer noInt = Integer.valueOf(no);
        // 最大期数
        int maxNo = 120;
        if (noInt < 1 || noInt > maxNo) {
            return ResUtils.error("必须是0-120期！");
        }
        int line = noInt / 20 + (noInt % 20 == 0 ? 0 : 1);
        // 把no转换成3位数
        no = SscUtils.frontZero(noInt, 3);
        SscVo vo = buySvc.nextNo(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), no);
        vo.setLine(line);
        return ResUtils.success(vo);
    }
}
