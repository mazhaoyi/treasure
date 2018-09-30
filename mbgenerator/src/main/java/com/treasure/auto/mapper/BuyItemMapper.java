package com.treasure.auto.mapper;

import com.treasure.auto.entity.BuyItem;
import com.treasure.auto.entity.BuyItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuyItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    long countByExample(BuyItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int deleteByExample(BuyItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int deleteByPrimaryKey(Integer buy_item_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int insert(BuyItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int insertSelective(BuyItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    List<BuyItem> selectByExample(BuyItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    BuyItem selectByPrimaryKey(Integer buy_item_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int updateByExampleSelective(@Param("record") BuyItem record, @Param("example") BuyItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int updateByExample(@Param("record") BuyItem record, @Param("example") BuyItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int updateByPrimaryKeySelective(BuyItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int updateByPrimaryKey(BuyItem record);
}