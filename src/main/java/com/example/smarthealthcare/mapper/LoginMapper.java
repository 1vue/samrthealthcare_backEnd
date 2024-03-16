package com.example.smarthealthcare.mapper;


import com.example.smarthealthcare.pojo.Login;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {


    Login login(Login l1);



}
