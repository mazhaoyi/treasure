package com.treasure.analyze;

import com.treasure.common.spring.SpringConfigBase;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * spring 配置信息
 * @author: mazy
 * @date: 2018/5/25 10:56
 */
@SpringBootConfiguration
public class SpringConfig extends SpringConfigBase {

    /**
     * 加载静态资源
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        // 注册静态资源
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/templates/static/");
        // ico
        registry.addResourceHandler("favicon.ico")
                .addResourceLocations("classpath:/templates/static/img/favicon.ico");
        // now资源
        registry.addResourceHandler("index.html")
                .addResourceLocations("classpath:/templates/index.html");
        // zu资源
        registry.addResourceHandler("zu.html")
                .addResourceLocations("classpath:/templates/zu.html");
        // 杀号资源
        registry.addResourceHandler("sha.html")
                .addResourceLocations("classpath:/templates/sha.html");
        // 组60资源
        registry.addResourceHandler("60.html")
                .addResourceLocations("classpath:/templates/60.html");

    }

}
