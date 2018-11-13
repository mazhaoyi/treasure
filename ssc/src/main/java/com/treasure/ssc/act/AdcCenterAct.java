package com.treasure.ssc.act;

import com.treasure.common.util.ResultUtils;
import com.treasure.ssc.svc.AdcCenterSvc;
import com.treasure.ssc.vo.TicketSscVo;
import com.treasure.ssc.vo.adc.req.BuyReqVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 模拟中心
 * @author: mazy
 * @date: 2018/11/12 15:23
 */
@RestController
@RequestMapping(value = "/adc")
public class AdcCenterAct {
    private static final Logger logger = LoggerFactory.getLogger(AdcCenterAct.class);

    @Autowired
    private AdcCenterSvc adcCenterSvc;

    /**
     * 今天已经出了的期号
     * @return
     */
    @PostMapping(value = "/list")
    public Object list() {
        return null;
    }

    /**
     * 下一期期号
     * @return
     */
    @PostMapping(value = "/nextno")
    public Object nextNo() {
        TicketSscVo vo = null;
        try {
            vo = adcCenterSvc.nextNum();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResultUtils.error(e.getMessage());
        }
        return ResultUtils.success(vo);
    }

    /**
     * 购买下一期
     * @return
     */
    @PostMapping(value = "/buy")
    public Object buy(BuyReqVo reqVo) {
        BigDecimal res = null;
        try {
            res = adcCenterSvc.buy(reqVo);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            ResultUtils.error(e.getMessage());
        }
        return ResultUtils.success(res);
    }
}
