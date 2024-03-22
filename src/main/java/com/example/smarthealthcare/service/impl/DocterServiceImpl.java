package com.example.smarthealthcare.service.impl;

import com.example.smarthealthcare.mapper.DocterMapper;
import com.example.smarthealthcare.mapper.PatientMapper;
import com.example.smarthealthcare.pojo.*;
import com.example.smarthealthcare.service.DocterService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocterServiceImpl implements DocterService {
    @Autowired
    private DocterMapper docterMapper;

    @Autowired
    private PatientMapper patientMapper;

   public Docter baseInfo(String userName){


       return docterMapper.getInfo(userName);
   }




    @Override
    public pagination_illnessrecord searchRecord(String userName, IllnessRecord record,Integer pageSize, Integer currentPage) {

       Integer userId=docterMapper.getId(userName);

        PageHelper.startPage(currentPage,pageSize);
        List<IllnessRecord> illnessRecordList=docterMapper.searchRecord(userId,record);
        Page<IllnessRecord> p=(Page<IllnessRecord>) illnessRecordList;
        pagination_illnessrecord pagination=new pagination_illnessrecord(p.getResult(),p.getTotal());

        return pagination;

    }

    @Override
    public void addRecord(String userName, IllnessRecord record) {

        Integer docterId=docterMapper.getId(userName);
       Integer patientId=patientMapper.getUserIdByName(record.getPatientName());

       record.setTime(LocalDateTime.now());

       docterMapper.addRecord(patientId,docterId,record);

    }

    @Override
    public pagination_Reservation getReservation(String userName, Integer status, String patientName, Integer pageSize, Integer currentPage) {
        Integer docterId=docterMapper.getId(userName);
        PageHelper.startPage(currentPage,pageSize);

        List<Reservation> reservations=docterMapper.getReservation(docterId,status,patientName);
        Page<Reservation> p=(Page<Reservation>) reservations;
        pagination_Reservation paginationReservation=new pagination_Reservation(p.getResult(),p.getTotal());

        return paginationReservation;
    }

    @Override
    public void dealReservation( Integer id, Integer status) {


        docterMapper.dealReservation(id,status);
    }
}
