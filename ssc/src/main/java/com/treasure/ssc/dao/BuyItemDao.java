package com.treasure.ssc.dao;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: mazy
 * @date: 2018/9/28 17:30
 */
public interface BuyItemDao {
    /**
     * 查询某人的本期的下注
     * @param username
     * @param ticketId
     * @return
     */
    List<BigDecimal> selectMoneyNowNo(@Param("username") String username, @Param("ticketId") Integer ticketId);
}
