package com.example.apiSuarezPharma.repository;

import com.example.apiSuarezPharma.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query(value = "SELECT p FROM Doctor p WHERE p.email =:email AND p.password=:password")
    Doctor loginDoctor (String email, String password);

    @Query(value = "SELECT p FROM Doctor p WHERE p.idCategory.id =:id")
    List<Doctor> getDoctorsByCategory (Long id);

}
