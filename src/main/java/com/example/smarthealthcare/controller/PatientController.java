package com.example.smarthealthcare.controller;


import com.example.smarthealthcare.pojo.*;
import com.example.smarthealthcare.service.PatientService;
import com.example.smarthealthcare.utils.jwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class PatientController {

    @Autowired
   private PatientService patientService;


//    查询用户基本信息
    @GetMapping("/patient/baseInfo")
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

            Patient p=patientService.baseInfo(userName);

            return result.success(p,indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }
    }


//    查询患者患病信息
    @GetMapping("/patient/getIllnessRecord")
    public result searchAllRecord(@RequestHeader("token") String token){

        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);

          List<IllnessRecord> illnessRecordList=patientService.getIllnessRecord(userName);

            return result.success(illnessRecordList,indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }
    }


//    搜索患者病历
    @PostMapping("/patient/searchRecord")
    public result searchRecord(@RequestHeader("token") String token,IllnessRecord record,@RequestParam(defaultValue = "5") Integer pageSize,@RequestParam(defaultValue = "1") Integer currentPage){

        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);

//            List<IllnessRecord> illnessRecordList=patientService.searchIllnessRecord(userName,record);
pagination_illnessrecord pagination=patientService.searchIllnessRecord(userName,record,pageSize,currentPage);

            return result.success(pagination,indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }
    }

//    患者查找医生
    @PostMapping("/patient/findDocter")
    public result findDocter(@RequestHeader("token") String token,Docter d,@RequestParam(defaultValue = "5") Integer pageSize,@RequestParam(defaultValue = "1") Integer currentPage ){

        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);



            log.info("当前页面大小为 " +pageSize+"类型为"+pageSize.getClass().getName());
            log.info("当前页面为第" +currentPage+"页"+"类型为"+pageSize.getClass().getName());
            log.info(d.getName());
//            List<Docter> docters=patientService.findDocter(d,pageSize,currentPage);

            pagination pagination=patientService.findDocter(d,pageSize,currentPage);

            return result.success(pagination,indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }
    }

    @CrossOrigin
    @PutMapping("/changePassWord")
    public result changePassWord(@RequestHeader("token") String token, String passWord){
        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);

            log.info(passWord);
            patientService.changePassWord(userName,passWord);

            return result.success(null,indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }

    }

    @PutMapping("/patient/reservation")
    public result reservation(@RequestHeader("token") String token, Reservation reservation)
    {
        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);


            patientService.reservation(userName,reservation);

            return result.success(null,indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }



    }

    @PostMapping("/patient/checkReservationStatus")
    public result checkReservationStatus(@RequestHeader("token") String token,Integer status,String docterName,@RequestParam(defaultValue = "5") Integer pageSize,@RequestParam(defaultValue = "1") Integer currentPage){
        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);

//List<Reservation> reservationList=patientService.checkReservationStatus(userName,status,docterName,pageSize,currentPage);
pagination_Reservation paginationReservation=patientService.checkReservationStatus(userName,status,docterName,pageSize,currentPage);

            return result.success(paginationReservation,indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }


    }


    @DeleteMapping("/patient/deleteReservation")
    public result deleteReservation(@RequestHeader("token") String token,Integer id){
        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);

            patientService.deleteReservation(id);


            return result.success(null,indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }




    }


    }





