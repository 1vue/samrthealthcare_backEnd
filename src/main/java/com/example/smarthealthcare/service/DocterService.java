package com.example.smarthealthcare.service;

import com.example.smarthealthcare.pojo.*;

import java.util.List;

public interface DocterService {
    Docter baseInfo(String userName);

    pagination_illnessrecord searchRecord(String userName, IllnessRecord record,Integer pageSize, Integer currentPage);

    void addRecord(String userName, IllnessRecord record);

    pagination_Reservation getReservation(String userName, Integer status, String patientName, Integer pageSize, Integer currentPage);

    void dealReservation(Integer id, Integer status);
}
