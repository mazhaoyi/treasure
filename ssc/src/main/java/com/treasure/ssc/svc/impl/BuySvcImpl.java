package com.treasure.ssc.svc.impl;

import com.treasure.ssc.cons.SscConst;
import com.treasure.ssc.svc.BuySvc;
import com.treasure.ssc.svc.FrontSvc;
import com.treasure.ssc.vo.BuyVo;
import com.treasure.ssc.vo.SscVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;

/**
 * @author: mazy
 * @date: 2018/9/21 13:13
 */
@Service
public class BuySvcImpl implements BuySvc {
    @Autowired
    private FrontSvc frontSvc;

    @Override
    public SscVo nextNo(LocalDate date, String no) {
        // 获取当前开奖
        SscVo sscVo = frontSvc.getByDateAndNo(date, no);
        // 查询当前购票
        BuyVo buyVo = frontSvc.getNoMoney("mzy", date, no);
        // 如果没有买票，直接返回
        if (buyVo == null) {
            return sscVo;
        }
        // 如果有买票，计算是否中奖，中奖多少，然后存入金钱，后续撤单也存入金钱
        Integer aft3Count = sscVo.getAft3MaxCount();
        // 后三没有中奖
        if (aft3Count < 2) {
            return sscVo;
        }
        try {
            byte[] bytes = Files.readAllBytes(SscConst.BUY_DIR.resolve("mzy.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
