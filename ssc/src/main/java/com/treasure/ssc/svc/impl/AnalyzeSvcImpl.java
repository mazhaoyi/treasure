package com.treasure.ssc.svc.impl;

import com.treasure.ssc.cons.SscConst;
import com.treasure.ssc.svc.AnalyzeSvc;
import com.treasure.ssc.util.HttpUtils;
import com.treasure.ssc.util.SscUtils;
import com.treasure.ssc.vo.AnalyzeVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author: mazy
 * @date: 2018/10/9 14:52
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AnalyzeSvcImpl implements AnalyzeSvc {
    @Override
    public List<AnalyzeVo> getDateFromRemote(Date date) {
        Map<String, Object> params = null;
        if (date != null) {
            params = new HashMap<>(1);
            params.put("selectDay", DateFormatUtils.format(date, "yyyyMMdd"));
        }

        List<AnalyzeVo> datas = HttpUtils.postList(SscConst.DATA_URL, params, AnalyzeVo.class);
        if (CollectionUtils.isEmpty(datas)) {
            return datas;
        }
        datas.stream().sorted(Comparator.comparing(e -> e.getNo())).forEach(e -> {
            String num = e.getNum();
            String bef3Str = SscUtils.create3Before(num);
            String mid3Str = SscUtils.create3Middle(num);
            String aft3Str = SscUtils.create3After(num);
            e.setBef3MaxCount(SscUtils.maxCountChar(bef3Str));
            e.setBef3012(SscUtils.check012(bef3Str));
            e.setMid3MaxCount(SscUtils.maxCountChar(mid3Str));
            e.setMid3012(SscUtils.check012(mid3Str));
            e.setAft3MaxCount(SscUtils.maxCountChar(aft3Str));
            e.setAft3012(SscUtils.check012(aft3Str));
        });
        return datas;
    }
}
