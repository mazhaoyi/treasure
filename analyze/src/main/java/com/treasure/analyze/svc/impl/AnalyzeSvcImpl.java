package com.treasure.analyze.svc.impl;

import com.treasure.analyze.svc.AnalyzeSvc;
import com.treasure.analyze.vo.AnalyzeVo;
import com.treasure.common.util.HttpUtils;
import com.treasure.common.util.SscUtils;
import com.treasure.common.vo.Point;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: mazy
 * @date: 2018/10/9 14:52
 */
@Service
public class AnalyzeSvcImpl implements AnalyzeSvc {
    @Value("${self.data.data-url}")
    private String dataUrl;

    @Override
    public List<AnalyzeVo> getDateFromRemote(Date date) {
        Map<String, Object> params = null;
        if (date != null) {
            params = new HashMap<>(1);
            params.put("selectDay", DateFormatUtils.format(date, "yyyyMMdd"));
        }

        List<AnalyzeVo> datas = HttpUtils.postList(dataUrl, params, AnalyzeVo.class);
        if (CollectionUtils.isEmpty(datas)) {
            return datas;
        }
        datas.stream().sorted(Comparator.comparing(e -> e.getNo())).forEach(e -> {
            String num = e.getNum();
            // 前三
            String bef3Str = SscUtils.create3Before(num);
            // 中三
            String mid3Str = SscUtils.create3Middle(num);
            // 后三
            String aft3Str = SscUtils.create3After(num);
            // 万千十
            String wqs = SscUtils.pickUp3Char(num, Point.W, Point.Q, Point.S);
            // 万千个
            String wqg = SscUtils.pickUp3Char(num, Point.W, Point.Q, Point.G);
            // 万百十
            String wbs = SscUtils.pickUp3Char(num, Point.W, Point.B, Point.S);
            // 万百个
            String wbg = SscUtils.pickUp3Char(num, Point.W, Point.B, Point.G);
            // 万十个
            String wsg = SscUtils.pickUp3Char(num, Point.W, Point.S, Point.G);
            // 千百个
            String qbg = SscUtils.pickUp3Char(num, Point.Q, Point.B, Point.G);
            // 千十个
            String qsg = SscUtils.pickUp3Char(num, Point.Q, Point.S, Point.G);
            // 前三
            e.setBef3MaxCount(SscUtils.maxCountChar(bef3Str));
            e.setBef3012(SscUtils.check012(bef3Str));
            // 中三
            e.setMid3MaxCount(SscUtils.maxCountChar(mid3Str));
            e.setMid3012(SscUtils.check012(mid3Str));
            // 后三
            e.setAft3MaxCount(SscUtils.maxCountChar(aft3Str));
            e.setAft3012(SscUtils.check012(aft3Str));
            // 万千十
            e.setWqsMaxCount(SscUtils.maxCountChar(wqs));
            e.setWqs012(SscUtils.check012(wqs));
            // 万千个
            e.setWqgMaxCount(SscUtils.maxCountChar(wqg));
            e.setWqg012(SscUtils.check012(wqg));
            // 万百十
            e.setWbsMaxCount(SscUtils.maxCountChar(wbs));
            e.setWbs012(SscUtils.check012(wbs));
            // 万百个
            e.setWbgMaxCount(SscUtils.maxCountChar(wbg));
            e.setWbg012(SscUtils.check012(wbg));
            // 万十个
            e.setWsgMaxCount(SscUtils.maxCountChar(wsg));
            e.setWsg012(SscUtils.check012(wsg));
            // 千百个
            e.setQbgMaxCount(SscUtils.maxCountChar(qbg));
            e.setQbg012(SscUtils.check012(qbg));
            // 千十个
            e.setQsgMaxCount(SscUtils.maxCountChar(qsg));
            e.setQsg012(SscUtils.check012(qsg));
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
