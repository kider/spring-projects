package com.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


public class AccessFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(AccessFilter.class);


    @Override
    public String filterType() {
        //过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。pre，代表会在请求被路由之前执行
        return "pre";
    }

    @Override
    public int filterOrder() {
        //过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //判断该过滤器是否需要被执行
        return true;//这里直接反回true
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
//        HttpServletResponse response = ctx.getResponse();
//        response.setCharacterEncoding("UTF-8");

        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");

        if (accessToken == null) {
            logger.warn("access token is empty");
            ctx.setSendZuulResponse(false);//该请求，不对其进行路由
            ctx.setResponseStatusCode(401);//返回的错误码
//            ctx.setResponse(response);
//            ctx.setResponseBody("您没有权限访问该请求，请联系系统管理员");//内容
        }
        return null;
    }
}
