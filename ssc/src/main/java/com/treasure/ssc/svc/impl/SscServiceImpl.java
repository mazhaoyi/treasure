package com.treasure.ssc.svc.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.treasure.ssc.svc.SscService;
import com.treasure.ssc.util.SscConst;
import com.treasure.ssc.vo.SscVo;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
}
