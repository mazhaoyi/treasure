package com.treasure.ssc.svc.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.treasure.ssc.cons.SscConst;
import com.treasure.ssc.svc.FrontSvc;
import com.treasure.ssc.util.SscUtils;
import com.treasure.ssc.vo.BuyVo;
import com.treasure.ssc.vo.SscVo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author: mazy
 * @date: 2018/9/20 23:21
 */
@Service
public class FrontSvcImpl implements FrontSvc {
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
    public List<BuyVo> buyDouble(String username, LocalDate date, String no, BigDecimal start, int times) {
        List<BuyVo> list = Lists.newArrayList();
        // no转换成int类型
        int noInt = Integer.valueOf(no);
        for (int i = 0; i < times; i++) {
            // 本期金钱
            BigDecimal thisMoney = getMoneyByTimes(start, i + 1);
            // 总金钱
            BigDecimal allMoney = getAllMoney(username);
            // 剩余金钱写入文件
            saveMoney(allMoney, username);
            BuyVo buyVo = new BuyVo();
            buyVo.setDate(date);
            buyVo.setNo(SscUtils.frontZero(noInt++, 3));
            buyVo.setMoney(thisMoney);
            list.add(buyVo);
        }
        // 写入文件
        try {
            Files.write(SscConst.BUY_DIR.resolve(username + ".json"), JSON.toJSONBytes(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public BuyVo getNoMoney(String username, LocalDate date, String no) {
        try {
            List<BuyVo> list = JSON.parseArray(new String(Files.readAllBytes(SscConst.BUY_DIR.resolve(username + ".json")), Charset.defaultCharset()), BuyVo.class);
            Optional<BuyVo> optional = list.parallelStream().filter(e -> e.getNo().equals(no) && e.getDate().equals(date)).findFirst();
            return optional.isPresent() ? optional.get() : null;
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        FrontSvc frontService = new FrontSvcImpl();
        System.out.println(JSON.toJSONString(frontService.getNoMoney("mzy", LocalDate.of(2018, 9, 21), "105")));
    }
}
