package com.tesquare.web.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * <p>Compiler: miyf
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tesquare.web.filter.WebFilter.java
 * <p>作者: miyf
 * <p>创建时间: 2020年12月25日 10:59
 * <p>负责人: miyf
 * <p>修改者： miyf
 * <p>修改时间：
 */
@Component
public class WebFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 得到request上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 得到request域
        HttpServletRequest request = currentContext.getRequest();
        // 得到头信息
        String header = request.getHeader("Authorization");
        // 判断是否有头信息
        if (header != null && !"".equals(header)) {
            currentContext.addZuulRequestHeader("Authorization", header);
        }
        return null;
    }
}
