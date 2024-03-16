package com.example.smarthealthcare.service.impl;

import com.example.smarthealthcare.mapper.DocterMapper;
import com.example.smarthealthcare.mapper.PatientMapper;
import com.example.smarthealthcare.pojo.Docter;
import com.example.smarthealthcare.pojo.IllnessRecord;
import com.example.smarthealthcare.pojo.Reservation;
import com.example.smarthealthcare.service.DocterService;
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
    public List<IllnessRecord> searchRecord(String userName, IllnessRecord record) {

       Integer userId=docterMapper.getId(userName);

        return docterMapper.searchRecord(userId,record);
    }

    @Override
    public void addRecord(String userName, IllnessRecord record) {

        Integer docterId=docterMapper.getId(userName);
       Integer patientId=patientMapper.getUserIdByName(record.getPatientName());

       record.setTime(LocalDateTime.now());

       docterMapper.addRecord(patientId,docterId,record);

    }

    @Override
    public List<Reservation> getReservation(String userName, Integer status, String patientName) {
        Integer docterId=docterMapper.getId(userName);


        return docterMapper.getReservation(docterId,status,patientName);
    }

    @Override
    public void dealReservation( Integer id, Integer status) {


        docterMapper.dealReservation(id,status);
    }
}
