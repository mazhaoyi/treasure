package com.treasure.ssc.svc.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.treasure.ssc.cons.SscConst;
import com.treasure.ssc.svc.FrontService;
import com.treasure.ssc.util.SscUtils;
import com.treasure.ssc.vo.BuyVo;
import com.treasure.ssc.vo.SscVo;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

/**
 * @author: mazy
 * @date: 2018/9/20 23:21
 */
public class FrontServiceImpl implements FrontService {
    @Override
    public SscVo getByDateAndNo(LocalDate date, String no) {
        Path path = SscConst.SOURCE_DIR.resolve(date.toString() + ".json");
        try {
            byte[] bytes = Files.readAllBytes(path);
            List<SscVo> list = JSON.parseArray(new String(bytes, Charset.defaultCharset()), SscVo.class);
            SscVo vo = list.parallelStream().filter(e -> e.getNo().equals(no)).findFirst().get();
            return vo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BigDecimal getAllMoney(String username) {
        Path moneyPath = SscConst.MONEY_DIR.resolve(username + ".txt");
        try {
            String money = new String(Files.readAllBytes(moneyPath));
            BigDecimal bd = BigDecimal.valueOf(Double.valueOf(money));
            return bd;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BuyVo> buyDouble(LocalDate date, String no, BigDecimal start, int times) {
        List<BuyVo> list = Lists.newArrayList();
        // no转换成int类型
        int noInt = Integer.valueOf(no);
        for (int i = 0; i < times; i++) {
            BuyVo buyVo = new BuyVo();
            buyVo.setDate(date);
            buyVo.setNo(SscUtils.frontZero(noInt++, 3));
            buyVo.setMoney(getMoneyByTimes(start, i + 1));
            list.add(buyVo);
        }
        return list;
    }

    @Override
    public BuyVo getNoMoney(LocalDate date, String no) {
        return null;
    }

    @Override
    public BigDecimal getMoneyByTimes(BigDecimal start, int times) {
        BigDecimal end = start;
        for (int i = 1; i < times; i++) {
            end = end.multiply(BigDecimal.valueOf(2));
        }
        return end;
    }

    public static void main(String[] args) {
        FrontService frontService = new FrontServiceImpl();
        List<BuyVo> list = frontService.buyDouble(LocalDate.now(), "102", BigDecimal.valueOf(0.9), 5);
        System.out.println(JSON.toJSONString(list));
    }
}
