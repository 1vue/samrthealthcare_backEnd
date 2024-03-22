package com.example.smarthealthcare.service.impl;

import com.example.smarthealthcare.mapper.DocterMapper;
import com.example.smarthealthcare.mapper.PatientMapper;
import com.example.smarthealthcare.pojo.*;
import com.example.smarthealthcare.service.PatientService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Slf4j
@Service

public class PatientServiceImpl implements PatientService {


    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private DocterMapper docterMapper;
   public Patient baseInfo(String userName){


        return patientMapper.getInfo(userName);
    }

    @Override
    public List<IllnessRecord> getIllnessRecord(String userName) {

       Integer userId=patientMapper.getUserId(userName);


        return patientMapper.getIllnessRecord(userId);
    }

    @Override
    public pagination_illnessrecord searchIllnessRecord(String userName, IllnessRecord record,Integer pageSize, Integer currentPage) {
        Integer userId=patientMapper.getUserId(userName);

        log.info(record.getKind());

        PageHelper.startPage(currentPage,pageSize);
        List<IllnessRecord> illnessRecordList=patientMapper.searchIllnessRecord(userId,record);
        Page<IllnessRecord> p=(Page<IllnessRecord>) illnessRecordList;
        pagination_illnessrecord pagination=new pagination_illnessrecord(p.getResult(),p.getTotal());

        return pagination;
    }

    @Override
    public pagination findDocter(Docter d, Integer pageSize, Integer currentPage) {

        PageHelper.startPage(currentPage,pageSize);
        List<Docter> docter=patientMapper.findDocter(d);

        Page<Docter> p=(Page<Docter>) docter;

        pagination pagination=new pagination(p.getResult(),p.getTotal());
        return  pagination;
    }

    @Override
    public void changePassWord(String userName,String passWord) {
       log.info(passWord);
        patientMapper.changePassWord(userName,passWord);
    }

    @Override
    public void reservation(String userName, Reservation reservation) {

       Integer patientId=patientMapper.getUserId(userName);
      Integer docterId=docterMapper.getId(reservation.getDocterUserName());



       patientMapper.reservation(patientId,docterId, reservation);

    }

    @Override
    public pagination_Reservation checkReservationStatus(String userName, Integer status, String docterName,Integer pageSize, Integer currentPage) {


       log.info(pageSize.toString());
       log.info(currentPage.toString());

        Integer patientId=patientMapper.getUserId(userName);

        Integer start=(currentPage-1)*pageSize;

       List<Reservation> reservations =patientMapper.checkReservationStatus(patientId,status,docterName,start,pageSize);

       Long total=patientMapper.getTotal(patientId,status,docterName);

pagination_Reservation paginationReservation= new pagination_Reservation(reservations,total);
        return paginationReservation;
    }

    @Override
    public void deleteReservation(Integer id) {
        patientMapper.deleteReservation(id);
    }
}
