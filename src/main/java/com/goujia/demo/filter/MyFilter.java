package com.goujia.demo.filter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    private static final Logger logger = LoggerFactory.getLogger("normal");
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String uri = httpServletRequest.getRequestURI();
        logger.info("requestUri : {}" ,uri);
        if(!needFilterUri(uri)){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }
        if (needLogin(httpServletRequest)) {
            httpServletResponse.sendRedirect("login");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 判断是否需要登陆
     */
    boolean needLogin(HttpServletRequest httpServletRequest){
        String userName = httpServletRequest.getHeader("userName");
        String password = httpServletRequest.getHeader("password");
        logger.info("check user status , userName : {} , password : {}",userName,password);
        if(StringUtils.equals(userName,"goujia")&&StringUtils.equals(password,"123")){
            return false;
        }
        logger.info("user need login...");
        return true;
    }

    /**
     * 判断请求uri是否需要拦截
     * @param uri
     * @return
     */
    boolean needFilterUri(String uri){
        if(StringUtils.equals("/goujia/first/login",uri)){
            return false;
        }
        return true;
    }

}
