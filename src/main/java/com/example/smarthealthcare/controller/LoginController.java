package com.example.smarthealthcare.controller;

import com.example.smarthealthcare.pojo.Login;
import com.example.smarthealthcare.pojo.result;
import com.example.smarthealthcare.service.LoginService;
import com.example.smarthealthcare.utils.jwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;


//    登录
    @PostMapping("/login")
    public result login(Login l1){
        log.info("登录");

        Login l=loginService.login(l1);

        if(l!=null){
            Map<String,Object> claims=new HashMap<>();
            claims.put("userName",l.getUserName());
            claims.put("indentify",l.getIndentify());

            String jwt= jwtUtils.generatejwt(claims);

            return result.success(jwt,l.getIndentify());
        }




        return result.error("用户名或密码错误");



    }


}
