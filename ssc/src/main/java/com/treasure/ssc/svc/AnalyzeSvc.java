package com.treasure.ssc.svc;

import com.treasure.ssc.vo.AnalyzeVo;

import java.util.List;

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
    List<AnalyzeVo> getDateFromRemote();
}
