package com.treasure.ssc.dao;

import com.treasure.ssc.entity.BuyItem;
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

    /**
     * 查询需要撤单的钱
     * @param username
     * @param ticketId
     * @return
     */
    List<BigDecimal> selectMoneyRe(@Param("username")String username, @Param("ticketId") Integer ticketId);

    /**
     * 更新中奖未中奖
     * @param itemFlag
     * @param userId
     * @param ticketId
     * @return
     */
    int updateNowNo(@Param("itemFlag") Short itemFlag, @Param("userId") Integer userId, @Param("ticketId") Integer ticketId);

    /**
     * 撤单
     * @param userId
     * @return
     */
    int updateReNo(@Param("userId") Integer userId);

    /**
     * 批量插入
     * @param list
     * @return
     */
    int insertBatch(@Param("list") List<BuyItem> list);
}
