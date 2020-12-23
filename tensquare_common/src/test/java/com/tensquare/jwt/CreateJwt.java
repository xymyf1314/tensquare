package com.tensquare.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * <p>
 * <p>Compiler: miyf
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.jwt.CreateJwt.java
 * <p>作者: miyf
 * <p>创建时间: 2020年12月21日 11:33
 * <p>负责人: miyf
 * <p>修改者： miyf
 * <p>修改时间：
 */
public class CreateJwt {
    public static void main(String[] args) {
        // setIssuedAt 创建时间
        // signWith 编码方式和盐
        // setExpiration 过期时间
        // claim 里面可以放自己定义的key value
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("666")
                .setSubject("小马")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "itcast")
                .setExpiration(new Date(new Date().getTime() + 60000))
                .claim("role", "admin")
                .claim("age", "12");

        System.out.println(jwtBuilder.compact());
    }
}
