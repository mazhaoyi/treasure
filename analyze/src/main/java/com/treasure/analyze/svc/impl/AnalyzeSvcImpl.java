package com.treasure.analyze.svc.impl;

import com.treasure.analyze.svc.AnalyzeSvc;
import com.treasure.analyze.vo.AnalyzeVo;
import com.treasure.common.constant.SscConst;
import com.treasure.common.util.HttpUtils;
import com.treasure.common.util.SscUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: mazy
 * @date: 2018/10/9 14:52
 */
@Service
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
            // 前三
            e.setBef3MaxCount(SscUtils.maxCountChar(bef3Str));
            e.setBef3012(SscUtils.check012(bef3Str));
            // 中三
            e.setMid3MaxCount(SscUtils.maxCountChar(mid3Str));
            e.setMid3012(SscUtils.check012(mid3Str));
            // 后三
            e.setAft3MaxCount(SscUtils.maxCountChar(aft3Str));
            e.setAft3012(SscUtils.check012(aft3Str));
            // 五星组30
            e.setWxz30(SscUtils.checkZu30(num));
            // 五星组20
            e.setWxz20(SscUtils.checkZu20(num));
            // 五星组10
            e.setWxz10(SscUtils.checkZu10(num));
            // 五星组5
            e.setWxz5(SscUtils.checkZu5(num));
        });
        return datas;
    }
}
