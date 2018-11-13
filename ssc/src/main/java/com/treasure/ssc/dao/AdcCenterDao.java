package com.treasure.ssc.dao;

import com.treasure.ssc.entity.BuyItem;
import com.treasure.ssc.entity.SscUser;
import com.treasure.ssc.vo.TicketSscVo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author: mazy
 * @date: 2018/11/12 17:20
 */
public interface AdcCenterDao {
    /**
     * 根据日期，期号获取本期号码
     * @param date
     * @param no
     * @return
     */
    TicketSscVo getByDateAndNo(@Param("date") LocalDate date, @Param("no") String no);

    /**
     * 获取当天已经出过的期的列表
     * @param date
     * @param no
     * @return
     */
    List<TicketSscVo> listByDateAndNo(@Param("date") LocalDate date, @Param("no") String no);
    /**
     * 根据username更新user
     * @param user
     * @return
     */
    int updateSscUserByUsername(@Param("user") SscUser user);

    /**
     * 获取用户
     * @param userId
     * @return
     */
    SscUser getUserById(@Param("userId") Integer userId);

    /**
     * 获取用户
     * @param username
     * @return
     */
    SscUser getUserByUsername(@Param("username") String username);

    /**
     * 查询购买项
     * @param ticketId
     * @param itemFlag
     * @return
     */
    List<BuyItem> listBuyItem(@Param("ticketId") Integer ticketId, @Param("itemFlag") Short itemFlag);

    /**
     * 计算过当前期金钱后，修改购买状态为中奖，或者未中奖，这里先不考虑撤单
     * @param buyItemId
     * @param itemFlag
     * @return
     */
    int updateItemFlag(@Param("buyItemId") Integer buyItemId, @Param("itemFlag") Short itemFlag);

    /**
     * 购买一期组3
     * @param userId
     * @param ticketId
     * @param buyMoney
     * @return
     */
    int buyTicket(@Param("userId") Integer userId, @Param("ticketId") Integer ticketId, @Param("buyMoney") BigDecimal buyMoney);
}
