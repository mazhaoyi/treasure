package com.treasure.ssc.svc.impl;

import com.treasure.ssc.svc.BuySvc;
import com.treasure.ssc.svc.FrontSvc;
import com.treasure.ssc.vo.SscVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return sscVo;
    }
}
