package com.tensquare.jwt;

import io.jsonwebtoken.*;

import java.text.SimpleDateFormat;

/**
 * <p>
 * <p>Compiler: miyf
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.jwt.ParseJwtTest.java
 * <p>作者: miyf
 * <p>创建时间: 2020年12月21日 11:38
 * <p>负责人: miyf
 * <p>修改者： miyf
 * <p>修改时间：
 */
public class ParseJwtTest {
    public static void main(String[] args) {
        try {
            Claims claims = Jwts.parser().setSigningKey("itcast")
                    .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE2MDg1MjMyMDUsImV4cCI6MTYwODUyMzI2NSwicm9sZSI6ImFkbWluIiwiYWdlIjoiMTIifQ.4pnS1bpqRCetG10bfu9YzE8h9wX6EtlmTS-pZoZywSQ")
                    .getBody();
            System.out.println("用户id: " + claims.getId());
            System.out.println("用户名: " + claims.getSubject());
            System.out.println("用户角色: " + claims.get("role"));
            System.out.println("用户年龄: " + claims.get("age"));
            System.out.println("用户登录时间: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
            System.out.println("过期时间: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            System.out.println("已过期");
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
        } catch (MalformedJwtException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
