package com.treasure.ssc.ctl;

import com.alibaba.fastjson.annotation.JSONField;
import com.treasure.ssc.svc.BuySvc;
import com.treasure.ssc.vo.SscVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(value = "/nextno")
    public Object nextNo(String no, @JSONField(format = "yyyy-MM-dd") Date date) {
        if (!StringUtils.isNumeric(no)) {
            throw new RuntimeException("no must number");
        }
        if (StringUtils.compare("0", no) > 0 || StringUtils.compare(no, "120") > 0) {
            throw new RuntimeException("no must in 0-120");
        }
        SscVo vo = buySvc.nextNo(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), no);
        return vo;
    }
}
