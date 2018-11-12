package com.treasure.ssc.act;

import com.treasure.common.util.ResultUtils;
import com.treasure.ssc.svc.AdcCenterSvc;
import com.treasure.ssc.vo.TicketSscVo;
import com.treasure.ssc.vo.adc.req.BuyReqVo;
import com.treasure.ssc.vo.adc.req.NextnoReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟中心
 * @author: mazy
 * @date: 2018/11/12 15:23
 */
@RestController
@RequestMapping(value = "/adc")
public class AdcCenterAct {
    @Autowired
    private AdcCenterSvc adcCenterSvc;

    /**
     * 下一期期号
     * @return
     */
    @PostMapping(value = "/nextno")
    public Object nextNo(NextnoReqVo reqVo) {
        TicketSscVo vo = adcCenterSvc.nextNum(reqVo);
        return ResultUtils.success(vo);
    }

    /**
     * 购买下一期
     * @return
     */
    @PostMapping(value = "/buy")
    public Object buy(BuyReqVo reqVo) {
        return null;
    }
}
