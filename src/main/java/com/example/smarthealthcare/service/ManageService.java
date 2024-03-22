package com.example.smarthealthcare.service;

import com.example.smarthealthcare.pojo.Docter;
import com.example.smarthealthcare.pojo.Patient;
import com.example.smarthealthcare.pojo.pagination_patient;

import java.util.List;

public interface ManageService {
    void addPatient(Patient p);

    void addDocter(Docter d);

    void deleteDocter(String postUserName);

    pagination_patient getPatientData(Patient p, Integer pageSize, Integer currentPage);

    void resetCode(String postUserName);
}
