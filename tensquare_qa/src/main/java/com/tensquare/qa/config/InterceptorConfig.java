package com.tensquare.qa.config;

import com.tensquare.qa.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * <p>
 * <p>Compiler: miyf
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.user.config.InterceptorConfig.java
 * <p>作者: miyf
 * <p>创建时间: 2020年12月21日 17:25
 * <p>负责人: miyf
 * <p>修改者： miyf
 * <p>修改时间：
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器要声明拦截器对象和要拦截的请求
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/login/**");
    }
}
