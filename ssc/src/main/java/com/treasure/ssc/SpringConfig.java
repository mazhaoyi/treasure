package com.treasure.ssc;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.treasure.ssc.converter.String2DateConverter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * spring 配置信息
 * @author: mazy
 * @date: 2018/5/25 10:56
 */
@SpringBootConfiguration
public class SpringConfig extends WebMvcConfigurationSupport {

    /**
     * 请求参数-格式化
     * @param registry
     */
    @Override
    protected void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
        // 请求参数-日期转换
        registry.addConverter(new String2DateConverter());
    }

    /**
     * 响应参数-格式化
     * @param converters
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        // fastJsonHttpMessageConverter 这个是responseBody输出的时候按照fastJson格式输出，可以注释掉看下效果@JSONField
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        mediaTypes.add(MediaType.TEXT_PLAIN);
        mediaTypes.add(MediaType.MULTIPART_FORM_DATA);
        mediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                // 开启格式化
                SerializerFeature.PrettyFormat,
                // 输出map中value为null的值
                SerializerFeature.WriteMapNullValue,
                // 如果List为null那么输出[]
                SerializerFeature.WriteNullListAsEmpty,
                // 如果String为null，那么输出""
                SerializerFeature.WriteNullStringAsEmpty
        );
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        fastJsonHttpMessageConverter.setDefaultCharset(Charset.forName("UTF-8"));

        converters.add(fastJsonHttpMessageConverter);
    }

}
