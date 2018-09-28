package com.treasure.ssc.dao;

import com.treasure.ssc.entity.SscUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author: mazy
 * @date: 2018/9/28 17:30
 */
public interface SscUserDao {
    /**
     * 根据username查询用户
     * @param username
     * @return
     */
    SscUser getByUsername(@Param("username") String username);

    /**
     * 根据username更新金钱
     * @param sscUser
     * @return
     */
    int updateByUsername(@Param("sscUser") SscUser sscUser);
}
