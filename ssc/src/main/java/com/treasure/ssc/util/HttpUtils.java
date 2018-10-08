package com.treasure.ssc.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * HTTP请求工具类
 * @author: mazy
 * @date: 2018/10/8 12:23
 */
public class HttpUtils {
    /**
     * get请求
     * @param url
     * @param params
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T get(String url, Map<String, Object> params, Class<T> clazz) {
        String res = get(url, params);
        return JSON.parseObject(res, clazz);
    }

    /**
     * get请求
     * @param url
     * @param params
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> getList(String url, Map<String, Object> params, Class<T> clazz) {
        String res = get(url, params);
        return JSON.parseArray(res, clazz);
    }
    /**
     * get请求
     * @param url
     * @param params
     * @return
     */
    public static String get(String url, Map<String, Object> params) {
        CloseableHttpClient httpClient = null;
        HttpGet httpGet = null;
        CloseableHttpResponse httpResponse = null;
        HttpEntity httpEntity = null;
        String res = null;
        try {
            httpClient = HttpClients.createDefault();

            // 处理请求参数
            url = createPath(url, params);
            httpGet = new HttpGet(url);
            httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
            res = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(httpClient, null, httpGet, httpResponse, httpEntity);
        }
        return res;
    }

    /**
     * post 请求
     * @param url
     * @param params
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T post(String url, Map<String, Object> params, Class<T> clazz) {
        String res = post(url, params);
        return JSON.parseObject(res, clazz);
    }

    /**
     * post请求
     * @param url
     * @param params
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> postList(String url, Map<String, Object> params, Class<T> clazz) {
        String res = post(url, params);
        return JSON.parseArray(res, clazz);
    }
    /**
     * post 请求
     * @param url
     * @param params
     * @return
     */
    public static String post(String url, Map<String, Object> params) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        CloseableHttpResponse httpResponse = null;
        HttpEntity httpEntity = null;
        HttpEntity entity = null;
        String res = null;
        try {
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            // 处理请求参数
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> nvps = params.entrySet().stream().map(e -> new BasicNameValuePair(e.getKey(), String.valueOf(e.getValue()))).collect(Collectors.toList());
                entity = new UrlEncodedFormEntity(nvps);
                httpPost.setEntity(entity);
            }
            httpResponse = httpClient.execute(httpPost);
            httpEntity = httpResponse.getEntity();
            res = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(httpClient, entity, httpPost, httpResponse, httpEntity);
        }
        return res;
    }

    /**
     * 创建KV形式的参数(utf-8编码)
     * @param params
     * @return a=b&c=d
     */
    public static String createKvParams(Map<String, Object> params) throws IOException {
        Charset charset = Charset.forName("utf-8");
        String kvPath = createKvParams(params, charset);
        return kvPath;
    }

    /**
     * 创建KV形式的参数
     * @param params
     * @return a=b&c=d
     */
    public static String createKvParams(Map<String, Object> params, Charset charset) throws IOException {
        ByteArrayOutputStream os = null;
        String kvParams = null;
        try {
            if (params != null && !params.isEmpty()) {
                List<BasicNameValuePair> nvps = params.entrySet().stream().map(e -> new BasicNameValuePair(e.getKey(), e.getValue().toString())).collect(Collectors.toList());
                UrlEncodedFormEntity ufe = new UrlEncodedFormEntity(nvps, charset);
                os = new ByteArrayOutputStream();

                ufe.writeTo(os);
                kvParams = os.toString();
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    throw e;
                }
            }
        }
        return kvParams;
    }

    /**
     * K,V参数拼接到URL上 utf-8
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public static String createPath(String url, Map<String, Object> params) throws IOException {
        Charset charset = Charset.forName("utf-8");
        String path = createPath(url, params, charset);
        return path;
    }

    /**
     * K,V参数拼接到URL上
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public static String createPath(String url, Map<String, Object> params, Charset charset) throws IOException {
        String kvPath = createKvParams(params, charset);
        if (StringUtils.isNotBlank(kvPath)) {
            String qmark = "?";
            if (StringUtils.contains(url, qmark)) {
                url = url + "&" + kvPath;
            } else {
                url = url + "?" + kvPath;
            }
        }
        return url;
    }

    /**
     * 关闭连接
     * @param httpClient 客户端
     * @param entity 请求实体
     * @param httpRequest 请求参数
     * @param httpResponse 响应参数
     * @param httpEntity 响应实体
     */
    private static final void close(CloseableHttpClient httpClient, HttpEntity entity, HttpRequestBase httpRequest, CloseableHttpResponse httpResponse, HttpEntity httpEntity) {
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
        if (httpRequest != null) {
            httpRequest.releaseConnection();
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

}
