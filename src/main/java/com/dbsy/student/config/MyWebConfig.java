package com.dbsy.student.config;

import com.dbsy.student.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:login.html");
    }

    @Bean
    public FilterRegistrationBean loginFilter() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new LoginFilter());
        List list = new ArrayList<String>();
        list.add("/index");
        frBean.setUrlPatterns(list);
        return frBean;
    }
}
