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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger logger = LoggerFactory.getLogger(SscServiceImpl.class);

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
            return countMoney;
        }
        // 是否红了
        boolean redFlag = false;
        // 当前是第几注
        int ticket = 0;

        list = list.stream().sorted(Comparator.comparing(e -> e.getNo())).collect(Collectors.toList());

        logger.info("开始计算，总金钱={}，首注金钱={}", countMoney, startMoney);
        // 开始计算
        for (int i = 0; i < list.size(); i++) {
            SscVo vo = list.get(i);

            /** 判断本次循环是否红了 **/
            // 后三组三计算
            Integer aft3MaxCount = vo.getAft3MaxCount();
            // 组三
            if (aft3MaxCount == SscConst.MAX_COUNT_3) {
                // 红了
                redFlag = true;
                logger.info("^_^ 本次红了，日期={}，期数={}，号码={}", vo.getDay(), vo.getNo(), vo.getNum());
            // 非组三
            } else {
                // 不红
                redFlag = false;
                logger.info("本次红了，日期={}，期数={}，号码={}", vo.getDay(), vo.getNo(), vo.getNum());
            }

            /** 清算上次结果 */
            // 没有持票
            if (ticket == 0) {
            // 第一次票
            } else if (ticket == 1) {
                // 红了
                if (redFlag) {
                    // 第一轮赏金
                    BigDecimal fee = startMoney.multiply(SscConst.ZU_3_MULTIPLE);
                    // 第二轮金钱
                    BigDecimal remain = startMoney.multiply(BigDecimal.valueOf(2));
                    // 1，返回第一轮赏金；2，撤回第二轮金钱；3，ticket标注为0
                    countMoney = countMoney.add(fee).add(remain);
                    ticket = 0;
                    logger.info("^_^ 第一票获得赏金={}，撤回第二轮金钱={}，归零票轮数={}", fee, remain, ticket);
                // 不红，那么标记下一轮
                } else {
                    ticket++;
                    logger.info("增加票轮数={}", ticket);
                }
            // 第二次票
            } else if (ticket == 2) {
                // 红了
                if (redFlag) {
                    // 第二轮赏金
                    BigDecimal fee = startMoney.multiply(BigDecimal.valueOf(2)).multiply(SscConst.ZU_3_MULTIPLE);
                    // 1，返回第二轮赏金；2，ticket标注为0
                    countMoney = countMoney.add(fee);
                    ticket = 0;
                    logger.info("^_^ 第二票获得赏金={}，归零票轮数={}", fee, ticket);
                // 不红ticket标注为0，结束
                } else {
                    ticket = 0;
                    logger.info("第二轮不中，归零票轮数={}", ticket);
                }
            }

            /** 如果本轮已经是倒数第二轮那么就不购买，总共120轮 */
            if (i > 117) {
                logger.warn("本轮已经是第 [{}] 期，不购买", vo.getNo());
                continue;
            }

            /** 购买新票 */

            // 第二次花费
            BigDecimal secondTime = startMoney.multiply(BigDecimal.valueOf(2));
            // 本次购买需要花费的钱 = 第一次花费 + 第二次花费
            BigDecimal cost = startMoney.add(secondTime);

            // 确定本轮红了，并且手中没有票，买票
            if (redFlag && ticket == 0) {
                // 本金已经无法支付一次购买，那么不再进行
                if (countMoney.compareTo(cost) < 0) {
                    logger.error("您的本金已经不够支付本次购买，本金={}，需要支付={}", countMoney, cost);
                    break;
                // 本金足够，支付本次购买金钱，ticket置为1
                } else {
                    logger.info("本金剩余=¥{}", countMoney);
                    countMoney = countMoney.subtract(cost);
                    ticket = 1;
                    logger.info("支付 ¥{}=¥{}+¥{} 后，剩余=¥{}", cost, startMoney, secondTime, countMoney);
                }
            }
        }
        logger.info("结束计算，总金钱={}", countMoney);
        return countMoney;
    }

}
