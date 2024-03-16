package com.example.smarthealthcare.service.impl;

import com.example.smarthealthcare.mapper.ManageMapper;
import com.example.smarthealthcare.pojo.Docter;
import com.example.smarthealthcare.pojo.Patient;
import com.example.smarthealthcare.service.ManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private ManageMapper manageMapper;


    @Override
    public void addPatient(Patient p) {

        manageMapper.setAccount(p);

        manageMapper.addPatient(p);

    }

    @Override
    public void addDocter(Docter d) {

        manageMapper.setDocterAccount(d);

        manageMapper.addDocter(d);


    }

    @Override
    public void deleteDocter(String postUserName) {


        log.info(postUserName);

        manageMapper.deleteAccount(postUserName);

        manageMapper.deleteDocter(postUserName);


    }

    @Override
    public List<Patient> getPatientData(Patient p) {



        return  manageMapper.getPatientData(p);
    }

    @Override
    public void resetCode(String postUserName) {

        manageMapper.resetCode(postUserName);
    }
}
