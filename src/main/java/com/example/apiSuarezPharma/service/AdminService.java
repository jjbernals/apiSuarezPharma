package com.example.apiSuarezPharma.service;


import com.example.apiSuarezPharma.entity.Admin;

import javax.security.sasl.AuthenticationException;
import java.util.List;

public interface AdminService {
    void createPromotor (Admin admin);
    void deleteAnPromotor (Long id);
    Admin loginAdmin(String email, String password) throws AuthenticationException;
    List<Admin> getAllPromotors ();
    List<Admin> getPromotorByName(String name);
    void updateAdmin(Long id,Admin admin);

}
