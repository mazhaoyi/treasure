package com.treasure.analyze;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * classpath:访问classpath下的内容，file:访问绝对路径下的文件
 * @PropertySource(value = {"classpath:config/prop-self.yml"}, ignoreResourceNotFound = true)
 * @PropertySource(value = {"file:F:/prop-self.yml"}, ignoreResourceNotFound = true)
 * application.yml从默认位置自动加载，不需要@PropertySource手动加入
 *
 * @author: mazy
 * @date: 2018/10/12 16:35
 */
@Component
@ConfigurationProperties(prefix = "self.data")
public class ConfigFile {
    /**
     * 源数据抓取地址
     */
    @Value("${data-url}")
    private String dataUrl;
    /**
     * 豹子数据抓取地址
     */
    @Value("${bz-url}")
    private String bzUrl;

    public String getDataUrl() {
        return this.dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public String getBzUrl() {
        return this.bzUrl;
    }

    public void setBzUrl(String bzUrl) {
        this.bzUrl = bzUrl;
    }
}
