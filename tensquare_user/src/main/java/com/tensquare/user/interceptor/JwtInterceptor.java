package com.tensquare.user.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> 权限拦截器
 * <p>Compiler: miyf
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.user.interceptor.JwtInterceptor.java
 * <p>作者: miyf
 * <p>创建时间: 2020年12月21日 17:21
 * <p>负责人: miyf
 * <p>修改者： miyf
 * <p>修改时间：
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {


    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("经过了拦截器");
        // 无论如何都放行。具体能不能操作还是在具体的操作中去判断
        // 拦截器只是负责把头请求头中包含token的令牌进行一个解析验证
        String header = request.getHeader("Authorization");
        if (header != null && !"".equals(header)) {
            // 如果包含头信息对其进行解析
            if (header.startsWith("Bearer ")) {
                // 得到token
                String token = header.substring(7);
                // 对令牌进行验证
                try {
                    Claims claims = jwtUtil.parseJWT(token);
                    String roles = (String) claims.get("roles");
                    if (roles != null && "admin".equals(roles)) {
                        request.setAttribute("claims_admin", token);
                    }
                    if (roles != null && "user".equals(roles)) {
                        request.setAttribute("claims_user", token);
                    }
                } catch (Exception e) {
                    throw new RuntimeException("令牌不正确！");
                }
            }
        }
        return true;
    }
}
