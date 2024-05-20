package com.marketplace.marketproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCconfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/templates/src/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/templates/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/templates/js/");
    }
}