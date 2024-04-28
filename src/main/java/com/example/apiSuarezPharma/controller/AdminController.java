package com.example.apiSuarezPharma.controller;

import com.example.apiSuarezPharma.entity.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.apiSuarezPharma.service.AdminServiceImpl;

import javax.security.sasl.AuthenticationException;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminServiceImpl adminService;

    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }
    @GetMapping
    public List<Admin> getAllPromotors(){ return adminService.getAllPromotors(); }

    @GetMapping("/{name}")
    public List<Admin> getPromotorByName(@PathVariable String name){ return adminService.getPromotorByName(name); }

    @GetMapping("/{email}/{password}")
    public Admin loginUser(@PathVariable String email, @PathVariable String password) throws AuthenticationException { return adminService.loginAdmin(email, password); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody Admin admin){ adminService.createPromotor(admin); }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody Admin admin, @PathVariable Long id){ adminService.updateAdmin(id, admin); }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnUser(@PathVariable Long id){ adminService.deleteAnPromotor(id); }
}
