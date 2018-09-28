package com.treasure.ssc.dao;

import com.treasure.ssc.entity.SscUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author: mazy
 * @date: 2018/9/28 17:30
 */
public interface SscUserDao {
    SscUser getByUsername(@Param("username") String username);
}
