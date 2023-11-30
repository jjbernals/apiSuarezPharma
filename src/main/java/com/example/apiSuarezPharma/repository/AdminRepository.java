package com.example.apiSuarezPharma.repository;


import com.example.apiSuarezPharma.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query(value = "SELECT p FROM Admin p WHERE p.name LIKE %:name%")
    List<Admin> getAdminByName(String name);
    @Query(value = "SELECT p FROM Admin p WHERE p.email =:email AND p.password=:password")
    Admin loginAdmin (String email, String password);
}
