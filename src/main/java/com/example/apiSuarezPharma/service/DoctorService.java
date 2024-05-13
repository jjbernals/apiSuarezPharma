package com.example.apiSuarezPharma.service;

import com.example.apiSuarezPharma.entity.Doctor;

import javax.print.Doc;
import javax.security.sasl.AuthenticationException;
import java.util.List;

public interface DoctorService {
    void createDoctor(Doctor doctor, Long id);
    void deleteDoctor(Long id);
    List<Doctor> getAllDoctors();
    List<Doctor> getDoctorsByCategory(Long id);
    void updateDoctor(Doctor doctor, Long id);
    Doctor loginDoctor(String email, String password) throws AuthenticationException;

}
