package com.treasure.ssc;

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
        // 首页资源
        registry.addResourceHandler("index.html")
                .addResourceLocations("classpath:/templates/index.html");
    }

}
