package com.goujia.demo.config;

import com.goujia.demo.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean myFilterRegistration(){
        //新建过滤器注册类
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        MyFilter myFilter = new MyFilter();
        //添加自定义的过滤器
        filterRegistrationBean.setFilter(myFilter);
        //添加拦截路径
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

}
