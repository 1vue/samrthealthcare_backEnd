package com.example.smarthealthcare.service;

import com.example.smarthealthcare.pojo.Docter;
import com.example.smarthealthcare.pojo.Patient;

import java.util.List;

public interface ManageService {
    void addPatient(Patient p);

    void addDocter(Docter d);

    void deleteDocter(String postUserName);

    List<Patient> getPatientData(Patient p);

    void resetCode(String postUserName);
}
