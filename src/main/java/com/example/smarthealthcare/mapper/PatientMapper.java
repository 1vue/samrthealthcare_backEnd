package com.example.smarthealthcare.mapper;


import com.example.smarthealthcare.pojo.Docter;
import com.example.smarthealthcare.pojo.IllnessRecord;
import com.example.smarthealthcare.pojo.Patient;
import com.example.smarthealthcare.pojo.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PatientMapper {


//    查找患者基本信息
    Patient getInfo(String userName);

//获取患者全部患病信息
    List<IllnessRecord> getIllnessRecord(Integer userId);


    //    获取患者id
    Integer getUserId(String userName);

    Integer getUserIdByName(String name);

//    搜索患者病历
    List<IllnessRecord> searchIllnessRecord(Integer userId,@Param("records") IllnessRecord record);

    List<Docter> findDocter(Docter d);

    void changePassWord(String userName,String passWord);

    void reservation(Integer patientId,Integer docterId,@Param("reservations") Reservation reservation);

    List<Reservation> checkReservationStatus(Integer patientId, Integer status, String docterName);

    void deleteReservation(Integer id);
}
