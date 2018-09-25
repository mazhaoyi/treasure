package com.treasure.ssc.ctl;

import com.alibaba.fastjson.annotation.JSONField;
import com.treasure.ssc.svc.BuySvc;
import com.treasure.ssc.vo.SscVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.ZoneId;
import java.util.Date;

/**
 * @author: mazy
 * @date: 2018/9/21 12:19
 */
@Controller
@RequestMapping(value = "/buy")
public class BuyTicketCtl {
    @Autowired
    private BuySvc buySvc;

    @GetMapping(value = "/nextno")
    public String nextNo(String no, @JSONField(format = "yyyy-MM-dd") Date date, ModelMap modelMap) {
        if (!StringUtils.isNumeric(no)) {
            throw new RuntimeException("no must number");
        }
        if (StringUtils.compare("0", no) > 0 || StringUtils.compare(no, "120") > 0) {
            throw new RuntimeException("no must in 0-120");
        }
        SscVo vo = buySvc.nextNo(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), no);
        modelMap.put("vo", vo);
        modelMap.put("test", "中文");
        return "mainplant";
    }
}
