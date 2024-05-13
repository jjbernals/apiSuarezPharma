package com.example.apiSuarezPharma.controller;

import com.example.apiSuarezPharma.entity.Doctor;
import com.example.apiSuarezPharma.service.DoctorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.security.sasl.AuthenticationException;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorServiceImpl doctorService;

    public DoctorController(DoctorServiceImpl doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors () { return doctorService.getAllDoctors(); }

    @GetMapping("/{email}/{password}")
    public Doctor loginDoctor(@PathVariable String email, @PathVariable String password) throws AuthenticationException { return doctorService.loginDoctor(email, password); }

    @GetMapping("/{id}")
    public List<Doctor> getDoctorsByCategory(@PathVariable Long id) { return doctorService.getDoctorsByCategory(id); }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDoctor (@RequestBody Doctor doctor, @PathVariable Long id) { doctorService.createDoctor(doctor, id); }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDoctor (@RequestBody Doctor doctor, @PathVariable Long id) { doctorService.updateDoctor(doctor, id); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor (@PathVariable Long id) { doctorService.deleteDoctor(id); }
}
