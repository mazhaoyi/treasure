package com.treasure.ssc.svc;

import com.treasure.ssc.cons.SscConst;
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
 * @date: 2018/9/20 23:15
 */
public interface FrontService {
    /**
     * 初始化数据
     * @param allMoney
     * @return
     */
    default boolean init(BigDecimal allMoney, String username) {
        try {
            Path moneyPath = SscConst.MONEY_DIR.resolve(username + ".txt");
            if (Files.notExists(moneyPath)) {
                Files.createDirectories(moneyPath.getParent());
                Files.createFile(moneyPath);
            }
            // 初始化金钱
            Files.write(moneyPath, allMoney.toString().getBytes(Charset.defaultCharset()));
            // 清空购买记录
            Files.walk(SscConst.BUY_DIR).filter(e -> !Files.isDirectory(e)).forEach(e -> {
                try {
                    Files.deleteIfExists(e);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * 根据日期和期数查询数据
     * @param date
     * @param no
     * @return
     */
    SscVo getByDateAndNo(LocalDate date, String no);

    /**
     * 根据用户名获取用户的总金钱
     * @param username
     * @return
     */
    BigDecimal getAllMoney(String username);

    /**
     * 翻倍追票
     * @param date 日期
     * @param no 期数
     * @param start 起始资金
     * @param times 一次追几期
     * @return
     */
    List<BuyVo> buyDouble(LocalDate date, String no, BigDecimal start, int times);

    /**
     * 根据日期，期数，查询这一期下注多少钱
     * @param date 日期
     * @param no 期数
     * @return
     */
    BuyVo getNoMoney(LocalDate date, String no);

    /**
     * 根据初始金钱，第几次翻倍，计算这一期的金钱数
     * @param start 初始金钱
     * @param times 第几次翻倍
     * @return
     */
    BigDecimal getMoneyByTimes(BigDecimal start, int times);
}
