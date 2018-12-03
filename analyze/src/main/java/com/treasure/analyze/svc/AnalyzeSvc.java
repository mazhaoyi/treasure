package com.treasure.analyze.svc;


import com.treasure.analyze.vo.AnalyzeVo;
import com.treasure.analyze.vo.ShaVo;

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
     * 获取杀号列表
     * @param date
     * @return
     */
    List<ShaVo> getShaDateFromRemote(Date date, String shaNum);

    /**
     * 统计后三数字次数
     * @param date
     * @return
     */
    List<String> mapAllNum(Date date, String no, String endNo, Boolean all);
}
