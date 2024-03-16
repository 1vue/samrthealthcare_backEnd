package com.example.smarthealthcare.mapper;

import com.example.smarthealthcare.pojo.Docter;
import com.example.smarthealthcare.pojo.Patient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManageMapper {


    void addPatient(Patient p);

    void setAccount(Patient p);


    void addDocter(Docter d);

    void setDocterAccount(Docter d);

    void deleteAccount(String postUserName);

    void deleteDocter(String postUserName);

    List<Patient> getPatientData(Patient p);

    void resetCode(String postUserName);
}
