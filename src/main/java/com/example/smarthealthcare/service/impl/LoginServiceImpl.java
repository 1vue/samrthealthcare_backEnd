package com.example.smarthealthcare.service.impl;

import com.example.smarthealthcare.mapper.LoginMapper;
import com.example.smarthealthcare.pojo.Login;
import com.example.smarthealthcare.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private LoginMapper loginMapper;


    public Login login(Login l1){


        return loginMapper.login(l1);
    }



}
