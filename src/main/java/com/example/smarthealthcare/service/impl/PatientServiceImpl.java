package com.example.smarthealthcare.service.impl;

import com.example.smarthealthcare.mapper.DocterMapper;
import com.example.smarthealthcare.mapper.PatientMapper;
import com.example.smarthealthcare.pojo.Docter;
import com.example.smarthealthcare.pojo.IllnessRecord;
import com.example.smarthealthcare.pojo.Patient;
import com.example.smarthealthcare.pojo.Reservation;
import com.example.smarthealthcare.service.PatientService;
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
    public List<IllnessRecord> searchIllnessRecord(String userName, IllnessRecord record) {
        Integer userId=patientMapper.getUserId(userName);

        log.info(record.getKind());
        return patientMapper.searchIllnessRecord(userId,record);
    }

    @Override
    public List<Docter> findDocter( Docter d) {


        return patientMapper.findDocter(d);
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
    public List<Reservation> checkReservationStatus(String userName, Integer status, String docterName) {

        Integer patientId=patientMapper.getUserId(userName);


        log.info(docterName);
        return patientMapper.checkReservationStatus(patientId,status,docterName);
    }

    @Override
    public void deleteReservation(Integer id) {
        patientMapper.deleteReservation(id);
    }
}
