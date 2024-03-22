package com.example.smarthealthcare.service.impl;

import com.example.smarthealthcare.mapper.ManageMapper;
import com.example.smarthealthcare.pojo.Docter;
import com.example.smarthealthcare.pojo.Patient;
import com.example.smarthealthcare.pojo.pagination_patient;
import com.example.smarthealthcare.service.ManageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public pagination_patient getPatientData(Patient p, Integer pageSize, Integer currentPage) {
        PageHelper.startPage(currentPage,pageSize);

        List<Patient> patients=manageMapper.getPatientData(p);
        Page<Patient> page=(Page<Patient>) patients;
        pagination_patient pagination_patient=new pagination_patient(page.getResult(),page.getTotal());


        return  pagination_patient;
    }

    @Override
    public void resetCode(String postUserName) {

        manageMapper.resetCode(postUserName);
    }
}
