package com.hp.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.protocol.RequestContent;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ZuulFilter
 * @Description zuul过滤器
 * @Author Ankhci
 * @Date 2019/12/29 22:35
 **/
@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //在转发之前进行过滤
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //在请求头之前查看参数
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        //需要过滤 改成True
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取请求的上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取Request请求
        HttpServletRequest request = currentContext.getRequest();
        //获取请求参数的值
        String token = request.getParameter("access-token");
        //判断是否为空
        if(StringUtils.isBlank(token)){
            //为空返回403
            currentContext.setResponseStatusCode(403);
            //不存在，未登陆，则拦截
            currentContext.setSendZuulResponse(false);
            // http://localhost:10010/api/user/1?access-token=1
        }
        return null;
    }
}
