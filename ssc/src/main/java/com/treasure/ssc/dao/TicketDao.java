package com.treasure.ssc.dao;

import com.treasure.ssc.entity.Ticket;
import com.treasure.ssc.vo.SscOutVo;
import com.treasure.ssc.vo.TicketSscVo;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: mazy
 * @date: 2018/9/28 15:11
 */
public interface TicketDao {
    /**
     * 批量插入
     * @param tickets
     * @return
     */
    int insertBatch(@Param("tickets") List<Ticket> tickets);

    /**
     * 根据NO和DATE查询
     * @param ticketNo
     * @param ticketDate
     * @return
     */
    SscOutVo getByNoAndDate(@Param("ticketNo") String ticketNo, @Param("ticketDate") LocalDate ticketDate);

    /**
     * 根据开始结束时间查询开奖号码
     * @param startDate
     * @param endDate
     * @return
     */
    List<TicketSscVo> ticketList(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
