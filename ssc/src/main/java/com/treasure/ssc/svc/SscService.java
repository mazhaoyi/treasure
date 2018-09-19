package com.treasure.ssc.svc;

import com.treasure.ssc.vo.SscVo;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: mazy
 * @date: 2018/9/18 13:31
 */
public interface SscService {
    /**
     * 查询某天的数据
     * @param date
     * @return
     */
    List<SscVo> list(LocalDate date);

    /**
     * 计算列表中的数据
     * @param list
     * @return
     */
    List<SscVo> reduceList(List<SscVo> list);
}
