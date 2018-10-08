package com.treasure.auto.mapper;

import com.treasure.auto.entity.BzType;
import com.treasure.auto.entity.BzTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BzTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz_type
     *
     * @mbg.generated
     */
    long countByExample(BzTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz_type
     *
     * @mbg.generated
     */
    int deleteByExample(BzTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz_type
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String bzTypeCode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz_type
     *
     * @mbg.generated
     */
    int insert(BzType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz_type
     *
     * @mbg.generated
     */
    int insertSelective(BzType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz_type
     *
     * @mbg.generated
     */
    List<BzType> selectByExample(BzTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz_type
     *
     * @mbg.generated
     */
    BzType selectByPrimaryKey(String bzTypeCode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz_type
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") BzType record, @Param("example") BzTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz_type
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") BzType record, @Param("example") BzTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz_type
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(BzType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz_type
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(BzType record);
}