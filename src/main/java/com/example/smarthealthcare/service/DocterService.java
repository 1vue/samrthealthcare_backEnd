package com.example.smarthealthcare.service;

import com.example.smarthealthcare.pojo.Docter;
import com.example.smarthealthcare.pojo.IllnessRecord;
import com.example.smarthealthcare.pojo.Reservation;

import java.util.List;

public interface DocterService {
    Docter baseInfo(String userName);

    List<IllnessRecord> searchRecord(String userName, IllnessRecord record);

    void addRecord(String userName, IllnessRecord record);

    List<Reservation> getReservation(String userName, Integer status, String patientName);

    void dealReservation(Integer id, Integer status);
}
