package com.example.smarthealthcare.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class jwtUtils {
    private static String signkey="test";
    private static Long expire=432000000L;


//    生成JWT令牌
    public static String generatejwt(Map<String,Object> claims){

        String jwt= Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,signkey)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+expire))
                .compact();
        return jwt;
    }

//    解析JWT令牌
    public static Claims parsejwt(String jwt){
        Claims claims=Jwts.parser()
                .setSigningKey(signkey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }

//    解析JWT令牌获取用户UserName
    public static String getUserName(String jwt){
Claims claims=parsejwt(jwt);
        String userName=claims.get("userName", String.class);
        return userName;
    }

    public static Integer getIndentify(String jwt){

        Claims claims=parsejwt(jwt);
        Integer indentify=claims.get("indentify", Integer.class);
        return indentify;

    }


}
