package com.treasure.auto.mapper;

import com.treasure.auto.entity.SscUser;
import com.treasure.auto.entity.SscUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SscUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssc_user
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    long countByExample(SscUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssc_user
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int deleteByExample(SscUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssc_user
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int deleteByPrimaryKey(Integer user_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssc_user
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int insert(SscUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssc_user
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int insertSelective(SscUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssc_user
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    List<SscUser> selectByExample(SscUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssc_user
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    SscUser selectByPrimaryKey(Integer user_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssc_user
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int updateByExampleSelective(@Param("record") SscUser record, @Param("example") SscUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssc_user
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int updateByExample(@Param("record") SscUser record, @Param("example") SscUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssc_user
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int updateByPrimaryKeySelective(SscUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssc_user
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    int updateByPrimaryKey(SscUser record);
}