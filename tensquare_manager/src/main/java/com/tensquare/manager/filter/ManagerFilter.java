package com.tensquare.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * <p> 后台过滤器
 * <p>Compiler: miyf
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.manager.filter.ManagerFilter.java
 * <p>作者: miyf
 * <p>创建时间: 2020年12月25日 10:46
 * <p>负责人: miyf
 * <p>修改者： miyf
 * <p>修改时间：
 */
@Component
public class ManagerFilter extends ZuulFilter {

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 表示在请求前（写pre）或者后（写post）执行执行
     * 日期: 10:47 2020/12/25
     * 作者: miyf
     *
     * @param
     * @return String
     **/
    @Override
    public String filterType() {
        return "pre";
    }


    /**
     * 多个过滤器的顺序，数字越小越先执行
     * 日期: 10:48 2020/12/25
     * 作者: miyf
     *
     * @return int
     **/
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 当前过滤器是否开启，true开启
     * 日期: 10:49 2020/12/25
     * 作者: miyf
     *
     * @param
     * @return boolean
     **/
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器内执行的操作，return任何object的值都表示继续执行。
     * setsendzullResponse（false）表示不再继续执行
     * 日期: 10:49 2020/12/25
     * 作者: miyf
     *
     * @param
     * @return Object
     **/
    @Override
    public Object run() throws ZuulException {
        System.out.println("经过后台过滤器了");
        // 得到request上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 得到request 域
        HttpServletRequest request = currentContext.getRequest();

        if (request.getMethod().equals("OPTIONS")) {
            return null;
        }
        if (request.getRequestURL().indexOf("login") > 0) {
            return null;
        }

        // 得到头信息
        String header = request.getHeader("Authorization");
        if (header != null && !"".equals(header)) {
            if (header.startsWith("Bearer ")) {
                String token = header.substring(7);
                try {
                    Claims claims = jwtUtil.parseJWT(token);
                    String roles = (String) claims.get("roles");
                    if ("admin".equals(roles)) {
                        // 把头信息转发下去并且放行
                        currentContext.addZuulRequestHeader("Authorization", header);
                        return null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    currentContext.setSendZuulResponse(false); // 终止运行
                }

            }
        }
        currentContext.setSendZuulResponse(false); // 终止运行
        currentContext.setResponseStatusCode(403);
        currentContext.setResponseBody("权限不足");
        currentContext.getResponse().setContentType("text/html;charset=utf-8");
        return null;
    }
}
