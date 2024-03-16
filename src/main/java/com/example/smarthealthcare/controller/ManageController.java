package com.example.smarthealthcare.controller;

import com.example.smarthealthcare.pojo.Docter;
import com.example.smarthealthcare.pojo.IllnessRecord;
import com.example.smarthealthcare.pojo.Patient;
import com.example.smarthealthcare.pojo.result;
import com.example.smarthealthcare.service.IllnessRecordService;
import com.example.smarthealthcare.service.ManageService;
import com.example.smarthealthcare.utils.jwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class ManageController {


    @Autowired
    private ManageService manageService;
    @Autowired
    private IllnessRecordService illnessRecordService;
    @PostMapping("/manage/getAllRecord")
    public result getAllRecord(@RequestHeader("token") String token,IllnessRecord i){
        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);

            List<IllnessRecord> illnessRecordList=illnessRecordService.getAllRecord(indentify,i);

            if(illnessRecordList!=null)
                return result.success(illnessRecordList,indentify);
            else
                return result.error("权限不够",indentify);

        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }
    }



    @PostMapping("/manage/getPatientData")
    public result getPatientData(@RequestHeader("token") String token,Patient p)
    {
        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);

            if(indentify==3) {
               List<Patient> patientList=manageService.getPatientData(p);
                return result.success(patientList, indentify);
            }
            else
                return result.error("权限不够",indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }


    }




//    新增病人



    @PutMapping("/manage/addPatient")
    public result addPatient(@RequestHeader("token") String token,Patient p){
        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);

                if(indentify==3) {
                    manageService.addPatient(p);
                    return result.success(null, indentify);
                }
               else
                   return result.error("权限不够",indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }


    }

    @PutMapping("/manage/addDocter")
    public result addDocter(@RequestHeader("token") String token, Docter d){

        try {
            // 移除 "Bearer " 前缀，只保留令牌部分
            String jwt = token.replace("Bearer ", "");

            // 从claims中获取用户userName
            String userName = jwtUtils.getUserName(jwt);

            Integer indentify=jwtUtils.getIndentify(jwt);
            log.info("当前用户用户名: " + userName);
            log.info("当前用户身份: " +indentify);

            if(indentify==3) {
                manageService.addDocter(d);
                return result.success(null, indentify);
            }
            else
                return result.error("权限不够",indentify);
        } catch (Exception e) {
            // 处理异常，例如令牌无效或已过期
            log.error("处理请求时发生错误: " + e.getMessage());
            return result.error("处理请求时发生错误");
        }


    }

    @DeleteMapping("/manage/deleteDocter")
public result deleteDocter(@RequestHeader("token") String token,String postUserName){
    try {
        // 移除 "Bearer " 前缀，只保留令牌部分
        String jwt = token.replace("Bearer ", "");

        // 从claims中获取用户userName
        String userName = jwtUtils.getUserName(jwt);

        Integer indentify=jwtUtils.getIndentify(jwt);
        log.info("当前用户用户名: " + userName);
        log.info("当前用户身份: " +indentify);

        if(indentify==3) {
            manageService.deleteDocter(postUserName);
            return result.success(null, indentify);
        }
        else
            return result.error("权限不够",indentify);
    } catch (Exception e) {
        // 处理异常，例如令牌无效或已过期
        log.error("处理请求时发生错误: " + e.getMessage());
        return result.error("处理请求时发生错误");
    }


}


@PutMapping("/manage/resetCode")
public result resetCode(@RequestHeader("token") String token,String postUserName){

    try {
        // 移除 "Bearer " 前缀，只保留令牌部分
        String jwt = token.replace("Bearer ", "");

        // 从claims中获取用户userName
        String userName = jwtUtils.getUserName(jwt);

        Integer indentify=jwtUtils.getIndentify(jwt);
        log.info("当前用户用户名: " + userName);
        log.info("当前用户身份: " +indentify);

        if(indentify==3) {
            manageService.resetCode(postUserName);
            return result.success(null, indentify);
        }
        else
            return result.error("权限不够",indentify);
    } catch (Exception e) {
        // 处理异常，例如令牌无效或已过期
        log.error("处理请求时发生错误: " + e.getMessage());
        return result.error("处理请求时发生错误");
    }


}



}
