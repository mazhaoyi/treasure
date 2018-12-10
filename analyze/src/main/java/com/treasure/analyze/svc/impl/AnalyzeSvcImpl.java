package com.treasure.analyze.svc.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.treasure.analyze.svc.AnalyzeSvc;
import com.treasure.analyze.vo.AnalyzeVo;
import com.treasure.analyze.vo.ShaVo;
import com.treasure.common.util.HttpUtils;
import com.treasure.common.util.SscUtils;
import com.treasure.common.vo.Point;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public List<ShaVo> getShaDateFromRemote(Date date, String shaNum) {
        Map<String, Object> params = null;
        if (date != null) {
            params = new HashMap<>(1);
            params.put("selectDay", DateFormatUtils.format(date, "yyyyMMdd"));
        }

        List<ShaVo> datas = HttpUtils.postList(dataUrl, params, ShaVo.class);
        if (CollectionUtils.isEmpty(datas)) {
            return datas;
        }

        datas = datas.stream().filter(e -> StringUtils.isNotBlank(e.getNum())).collect(Collectors.toList());
        Map<Integer, ShaVo> tmpMap = datas.stream().collect(Collectors.toMap(e -> Integer.valueOf(e.getNo()), e -> e));
        datas.stream().sorted(Comparator.comparing(e -> e.getNo())).forEach(e -> {
            Integer nowNo = Integer.valueOf(e.getNo());
            Integer nextNo = nowNo + 1;
            Integer no1 = nowNo;
            Integer no2 = nowNo - 1;
            if (nowNo < 2) {
                return;
            }
            if (nextNo > 120) {
                return;
            }
            ShaVo shaVo1 = tmpMap.get(no1);
            ShaVo shaVo2 = tmpMap.get(no2);


            List<Integer> list1 = null;
            List<Integer> list2 = null;

            if (shaVo1 != null) {
                String num1 = shaVo1.getNum();
                list1 = SscUtils.str2list(num1);
            } else {
                list1 = Lists.newArrayList();
            }
            if (shaVo2 != null) {
                String num2 = shaVo2.getNum();
                list2 = SscUtils.str2list(num2);
            } else {
                list2 = Lists.newArrayList();
            }

            List<Integer> listAllNum = Lists.newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
            listAllNum.removeAll(list1);
            listAllNum.removeAll(list2);

            ShaVo nextVo = tmpMap.get(nextNo);
            if (nextVo == null) {
                nextVo = new ShaVo();
                nextVo.setNo(SscUtils.frontZero(nextNo, 3));
                nextVo.setShaNum(SscUtils.list2str(listAllNum));
                tmpMap.put(nextNo, nextVo);
            } else {
                nextVo.setShaNum(SscUtils.list2str(listAllNum));
            }

        });

        List<ShaVo> results = tmpMap.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey())).map(e -> e.getValue()).collect(Collectors.toList());
        results.stream().forEach(e -> {
            String num = e.getNum();
            /// 不删除
//            String shaNum = e.getShaNum();
//            String shaNum = "018";
            if (StringUtils.isNotBlank(num) && StringUtils.isNotBlank(shaNum)) {
                String aftstr = SscUtils.create3After(num);
                Integer maxCount = SscUtils.maxCountChar(aftstr);
                if (maxCount == 1) {
                    List<Integer> check1 = SscUtils.str2list(aftstr);
                    List<Integer> check2 = SscUtils.str2list(shaNum);
                    check1.retainAll(check2);

                    if (CollectionUtils.isEmpty(check1)) {
                        e.setIfAftSha(true);
                    }
                }
            }

            Boolean ifAftSha = e.getIfAftSha();
            if (ifAftSha == null) {
                e.setIfAftSha(false);
            }
        });

        return results;
    }

    @Override
    public List<String> mapAllNum(Date date, String no, String endNo, Boolean all) {
        String url = "http://39.108.143.25:8080/stock/cqssc/getCurrentDay.sc";

        if (StringUtils.isBlank(no)) {
            no = "001";
        }
        if (StringUtils.isBlank(endNo)) {
            endNo = "120";
        }

        if (all == null) {
            all = false;
        }

        Boolean ifAll = all;
        Integer comNo = Integer.valueOf(no);
        Integer tmpEndNo = Integer.valueOf(endNo);

        Map<String, Object> params = new HashMap<>(1);
        params.put("selectDay", DateFormatUtils.format(date, "yyyyMMdd"));
        List<ShaVo> datas = HttpUtils.postList(url, params, ShaVo.class);
        datas = datas.stream()
                .filter(e -> (Integer.valueOf(e.getNo()) >= comNo) && (Integer.valueOf(e.getNo()) <= tmpEndNo))
                .collect(Collectors.toList());
        StringBuffer sb = new StringBuffer();
        if (CollectionUtils.isNotEmpty(datas)) {
            datas.stream().filter(e -> StringUtils.isNotBlank(e.getNum())).forEach(e -> {
                String n = e.getNum();
                if (ifAll) {
                    sb.append(n);
                } else {
                    sb.append(SscUtils.create3After(n));
                }

            });
        }

        Map<Integer, Integer> tmpMap = Maps.newHashMap();
        String str = sb.toString();
        for (int i = 0; i < 10; i++) {
            int count = StringUtils.countMatches(str, i + "");
            tmpMap.put(i, count);
        }
        List<String> list = tmpMap.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue())).map(e -> e.getKey() + "-" + e.getValue()).collect(Collectors.toList());
        return list;
    }

    public List<String> numCountList(Date date, String no, String endNo, Boolean all) {
        String url = "http://39.108.143.25:8080/stock/cqssc/getCurrentDay.sc";

        if (StringUtils.isBlank(no)) {
            no = "001";
        }
        if (StringUtils.isBlank(endNo)) {
            endNo = "120";
        }

        if (all == null) {
            all = false;
        }

        Boolean ifAll = all;
        Integer comNo = Integer.valueOf(no);
        Integer tmpEndNo = Integer.valueOf(endNo);

        Map<String, Object> params = new HashMap<>(1);
        params.put("selectDay", DateFormatUtils.format(date, "yyyyMMdd"));
        List<ShaVo> datas = HttpUtils.postList(url, params, ShaVo.class);
        datas = datas.stream()
                .filter(e -> (Integer.valueOf(e.getNo()) >= comNo) && (Integer.valueOf(e.getNo()) <= tmpEndNo))
                .map(e -> {
                    if (ifAll) {
                        return e;
                    } else {
                        e.setNum(SscUtils.create3After(e.getNum()));
                        return e;
                    }
                })
                .collect(Collectors.toList());
        return null;
    }

    public static void main(String[] args) {
        AnalyzeSvcImpl analyzeSvc = new AnalyzeSvcImpl();
        ///
        /*List<ShaVo> list = analyzeSvc.getShaDateFromRemote(new Date());
        System.out.println(JSON.toJSONString(list));*/
        Date date = Date.from(LocalDate.now().minusDays(0).atStartOfDay(ZoneId.systemDefault()).toInstant());
        analyzeSvc.mapAllNum(date, null, null,false);
    }
}
