package com.treasure.analyze.svc;


import com.treasure.analyze.vo.AnalyzeVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 分析当前数据
 * @author: mazy
 * @date: 2018/10/9 14:46
 */
public interface AnalyzeSvc {
    /**
     * 从远程获取当前数据
     * @return
     */
    List<AnalyzeVo> getDateFromRemote(Date date);

    /**
     * 5-组5，10-组10，20-组20，30-组30
     * 统计五星位置
     * @return
     */
    Map<Integer, Integer> analyzeWxSite(Integer flag);
}
