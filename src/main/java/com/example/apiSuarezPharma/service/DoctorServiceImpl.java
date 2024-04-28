package com.example.apiSuarezPharma.service;

import com.example.apiSuarezPharma.entity.Doctor;
import com.example.apiSuarezPharma.exception.DoctorNotFoundException;
import com.example.apiSuarezPharma.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import javax.security.sasl.AuthenticationException;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{
    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void createDoctor(Doctor doctor) {
        doctor.setRol("doctor");
        doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public void updateDoctor(Doctor doctor, Long id) {
        Doctor doctorResponse = doctorRepository.findById(id).orElseThrow(()->new DoctorNotFoundException("El doctor no se encuentra registrado"));
        doctor.setId(id);
        doctorRepository.save(doctor);
    }

    @Override
    public Doctor loginDoctor(String email, String password) throws AuthenticationException {
        Doctor doctor = doctorRepository.loginDoctor(email, password);
        if(doctor!= null){
            return doctor;
        }
        throw new AuthenticationException("Credenciales inválidas");
    }
}
