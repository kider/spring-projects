package com.spring.order.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

/**
 * @ClassName LoginFilter
 * @Description 用户登录验证
 * @Author kider
 * @Date 2020/3/26 17:59
 * @Version 1.0
 **/
@WebFilter(urlPatterns = "/order/*", filterName = "loginFilter")
@Order(1)
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (null != cookies) {
            Arrays.stream(cookies).forEach((cookie) -> {
                System.out.println(cookie);
            });
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
