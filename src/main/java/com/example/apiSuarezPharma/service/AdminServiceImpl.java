package com.example.apiSuarezPharma.service;


import com.example.apiSuarezPharma.entity.Admin;
import com.example.apiSuarezPharma.exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import com.example.apiSuarezPharma.repository.AdminRepository;

import javax.security.sasl.AuthenticationException;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void createPromotor(Admin admin) {
        admin.setRol("promotor");
        adminRepository.save(admin);
    }

    @Override
    public void deleteAnPromotor(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Admin loginAdmin(String email, String password) throws AuthenticationException {
        Admin admin = adminRepository.loginAdmin(email, password);
        if(admin!= null){
            return admin;
        }
        throw new AuthenticationException("Credenciales inválidas");
    }

    @Override
    public List<Admin> getAllPromotors() {
        return adminRepository.findAll();
    }

    @Override
    public List<Admin> getPromotorByName(String name) {
        return adminRepository.getAdminByName(name);
    }

    @Override
    public void updateAdmin(Long id, Admin admin) {
        Admin adminResult = adminRepository.findById(id).orElseThrow(()->new UserNotFoundException("No se encuentra disponible este usuario"));
        admin.setId(id);
        adminRepository.save(admin);
    }
}
