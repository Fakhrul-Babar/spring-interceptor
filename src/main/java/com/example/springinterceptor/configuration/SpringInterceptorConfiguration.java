package com.example.springinterceptor.configuration;

import com.example.springinterceptor.inerceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringInterceptorConfiguration  implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor());
//        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
