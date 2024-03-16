package com.example.smarthealthcare.service;

import com.example.smarthealthcare.pojo.Docter;
import com.example.smarthealthcare.pojo.IllnessRecord;
import com.example.smarthealthcare.pojo.Patient;
import com.example.smarthealthcare.pojo.Reservation;

import java.util.List;

public interface PatientService {


    Patient baseInfo(String userName);

    List<IllnessRecord> getIllnessRecord(String userName);

    List<IllnessRecord> searchIllnessRecord(String userName, IllnessRecord record);

    List<Docter> findDocter( Docter d);

    void changePassWord(String userName,String passWord);

    void reservation(String userName, Reservation reservation);

    List<Reservation> checkReservationStatus(String userName, Integer status, String docterName);

    void deleteReservation(Integer id);
}
