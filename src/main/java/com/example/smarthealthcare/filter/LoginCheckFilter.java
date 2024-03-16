package com.example.smarthealthcare.filter;

import com.alibaba.fastjson2.JSONObject;
import com.example.smarthealthcare.pojo.result;
import com.example.smarthealthcare.utils.jwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;


@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse res=(HttpServletResponse) servletResponse;

        String url=req.getRequestURL().toString();
        log.info("请求路径为{}",url);


        if(url.contains("login"))
        {   log.info("登录放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return;}

        String jwt=req.getHeader("token");

        if(!StringUtils.hasLength(jwt))
        {
            log.info("请求头为空，无token信息");
            result error=result.error("not_login");
            String notlogin=  JSONObject.toJSONString(error);

            res.getWriter().write(notlogin);
            return;
        }

        try{
            Claims claims= jwtUtils.parsejwt(jwt);
        } catch (Exception e){
            e.printStackTrace();
            log.info("登录失败");

            result error=result.error("未登录");
            String notlogin=  JSONObject.toJSONString(error);

            res.getWriter().write(notlogin);
            return;


        }

        log.info("放行");

        filterChain.doFilter(servletRequest,servletResponse);


    }
    }

