package com.example.smarthealthcare.controller;


import com.example.smarthealthcare.pojo.*;
import com.example.smarthealthcare.service.DocterService;
import com.example.smarthealthcare.service.IllnessRecordService;
import com.example.smarthealthcare.utils.jwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class DocterController {

    @Autowired
    private DocterService docterService;

    @Autowired
    private IllnessRecordService illnessRecordService;

//    查询医生基本信息
    @GetMapping("/docter/baseInfo")
    public result baseInfo(@RequestHeader("token") String token)
    {
        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);

            Docter d=docterService.baseInfo(userName);

            return result.success(d,indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }
    }



//    查找就诊信息
    @PostMapping("/docter/searchRecord")
    public result searchRecord(@RequestHeader("token") String token,IllnessRecord record,@RequestParam(defaultValue = "5") Integer pageSize,@RequestParam(defaultValue = "1") Integer currentPage){

        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);



//            List<IllnessRecord> list=docterService.searchRecord(userName,record);

            pagination_illnessrecord pagination_illnessrecord=docterService.searchRecord(userName,record,pageSize,currentPage);

            return result.success(pagination_illnessrecord,indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }


    }

//    新增病历


    @PutMapping("/docter/addRecord")
    public result addRecord(@RequestHeader("token") String token,IllnessRecord record){

        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);

            docterService.addRecord(userName,record);


            return result.success(null,indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }



    }

    @PostMapping("/docter/getReservation")
    public result getReservation(@RequestHeader("token") String token,Integer status,String patientName,@RequestParam(defaultValue = "5") Integer pageSize,@RequestParam(defaultValue = "1") Integer currentPage)
    {
        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);

//         List<Reservation>reservationList= docterService.getReservation(userName,status,patientName);

pagination_Reservation paginationReservation=docterService.getReservation(userName,status,patientName,pageSize,currentPage);
            return result.success(paginationReservation,indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }


    }

    @PutMapping("/docter/dealReservation")
    public result dealReservation(@RequestHeader("token") String token,Integer id,Integer status){
        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);

                docterService.dealReservation(id,status);


            return result.success(null,indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }


    }





}
