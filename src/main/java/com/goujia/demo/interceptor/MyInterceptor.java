package com.goujia.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger = LoggerFactory.getLogger("normal");

    /**
     * 在进入controller之前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("preHandle before controller...");
        return super.preHandle(request, response, handler);
    }

    /**
     * 在进入controller之后,返回之前执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle after controller...");
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 有了http响应之后,返回给前端之前执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("afterCompletion before return...");
        super.afterCompletion(request, response, handler, ex);
    }
}
