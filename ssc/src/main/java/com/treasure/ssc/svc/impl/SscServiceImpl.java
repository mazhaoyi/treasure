package com.treasure.ssc.svc.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.treasure.ssc.svc.SscService;
import com.treasure.ssc.cons.SscConst;
import com.treasure.ssc.util.SscUtils;
import com.treasure.ssc.vo.SscVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: mazy
 * @date: 2018/9/18 13:34
 */
public class SscServiceImpl implements SscService {

    @Override
    public List<SscVo> list(LocalDate date) {
        List<SscVo> list = null;
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        CloseableHttpResponse httpResponse = null;
        HttpEntity httpEntity = null;
        HttpEntity entity = null;
        try {
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(SscConst.DATA_URL);
            List<NameValuePair> nvs = Lists.newArrayList(new BasicNameValuePair("selectDay", date.format(DateTimeFormatter.ofPattern("yyyyMMdd"))));
            entity = new UrlEncodedFormEntity(nvs);
            httpPost.setEntity(entity);
            httpResponse = httpClient.execute(httpPost);
            httpEntity = httpResponse.getEntity();
            list = JSON.parseArray(EntityUtils.toString(httpEntity), SscVo.class);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (entity != null) {
                try {
                    EntityUtils.consume(entity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpPost != null) {
                httpPost.releaseConnection();
            }
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpEntity != null) {
                try {
                    EntityUtils.consume(httpEntity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    @Override
    public List<SscVo> reduceList(List<SscVo> list) {
        if (CollectionUtils.isEmpty(list)) {
            return list;
        }
        // num长度
        int numLength = 5;
        list.parallelStream().filter(e -> StringUtils.length(e.getNum()) == numLength).forEach(e -> {
            String num = e.getNum();
            // 前三字符串
            String num3Bef = SscUtils.create3Before(num);
            // 中三字符串
            String num3Mid = SscUtils.create3Middle(num);
            // 后三字符串
            String num3Aft = SscUtils.create3After(num);
            // 前三相同的数量
            int maxCount3Bef = SscUtils.maxCountChar(num3Bef);
            // 中三相同的数量
            int maxCount3Min = SscUtils.maxCountChar(num3Mid);
            // 后三相同的数量
            int maxCount3Aft = SscUtils.maxCountChar(num3Aft);
            e.setBef3MaxCount(maxCount3Bef);
            e.setMid3MaxCount(maxCount3Min);
            e.setAft3MaxCount(maxCount3Aft);
        });
        return list;
    }

    @Override
    public BigDecimal reduceMoney12OneDay(List<SscVo> list, BigDecimal countMoney, BigDecimal startMoney) {
        if (CollectionUtils.isEmpty(list)) {
            return BigDecimal.valueOf(0);
        }
        // 是否买
        boolean buyFlag = false;

        list = list.stream().sorted(Comparator.comparing(e -> e.getNo())).collect(Collectors.toList());
        // TODO 还没计算完
        for (SscVo vo : list) {
            // 本次购买需要花费的钱 = 第一次花费 + (2 * 第一次花费)
            BigDecimal cost = startMoney.add(startMoney.multiply(BigDecimal.valueOf(2)));

            // 确定本次要购买，并且剩余的钱够花
            if (buyFlag && countMoney.compareTo(startMoney) > 0) {
                // 如果1次中了
                // 如果1次没中，2次中了
                // 如果1次、2次都没中
            }

            // 后三组三计算
            Integer aft3MaxCount = vo.getAft3MaxCount();
            // 组三
            if (aft3MaxCount == SscConst.MAX_COUNT_3) {
                // 下次就购买
                buyFlag = true;
            // 非组三
            } else {
                // 下次就不买
                buyFlag = false;
            }

        }
        return null;
    }

}
