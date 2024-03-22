package com.example.smarthealthcare.service;

import com.example.smarthealthcare.pojo.*;

import java.util.List;


public interface PatientService {


    Patient baseInfo(String userName);

    List<IllnessRecord> getIllnessRecord(String userName);

    pagination_illnessrecord searchIllnessRecord(String userName, IllnessRecord record,Integer pageSize, Integer currentPage);

    pagination findDocter(Docter d, Integer pageSize, Integer currentPage);

    void changePassWord(String userName,String passWord);

    void reservation(String userName, Reservation reservation);

    pagination_Reservation checkReservationStatus(String userName, Integer status, String docterName,Integer pageSize, Integer currentPage);

    void deleteReservation(Integer id);
}
