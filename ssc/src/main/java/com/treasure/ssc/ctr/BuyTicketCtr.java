package com.treasure.ssc.ctr;

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
public class BuyTicketCtr {
    @Autowired
    private BuySvc buySvc;

    /**
     * 获取下一期数字
     * @param no
     * @param date
     * @return
     */
    @GetMapping(value = "/nextno")
    public Object nextNo(String no, @JSONField(format = "yyyy-MM-dd") Date date) {
        if (!StringUtils.isNumeric(no)) {
            return ResUtils.error("期数必须是数字！");
        }
        Integer noInt = Integer.valueOf(no);
        // 最大期数
        int maxNo = 120;
        if (noInt < 1) {
            return ResUtils.error("必须是从1期开始！");
        }
        if (noInt > maxNo) {
            return ResUtils.error(120, "最大期数为120！", null);
        }
        int line = noInt / 20 + (noInt % 20 == 0 ? 0 : 1);
        // 把no转换成3位数
        no = SscUtils.frontZero(noInt, 3);
        SscVo vo = buySvc.nextNo(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), no);
        vo.setLine(line);
        return ResUtils.success(vo);
    }

    /**
     * 购买票
     * @param no
     * @param date
     * @param count
     * @return
     */
    @GetMapping(value = "/buy")
    public Object compMoney(String no, @JSONField(format = "yyyy-MM-dd") Date date, Integer count) {
        if (count == null || count < 1) {
            return ResUtils.error("购买期数必须大于0！");
        }
        if (!StringUtils.isNumeric(no)) {
            return ResUtils.error("期数必须是数字！");
        }
        return null;
    }
}
