package com.example.apiSuarezPharma.controller;

import com.example.apiSuarezPharma.entity.UserBenefits;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.apiSuarezPharma.service.UserBenefitsServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/user-benefits")
public class UserBenefitsController {
    private final UserBenefitsServiceImpl userBenefitsService;

    public UserBenefitsController(UserBenefitsServiceImpl userBenefitsService) {
        this.userBenefitsService = userBenefitsService;
    }
    @GetMapping
    private List<UserBenefits> getAllBenefits(){ return userBenefitsService.getAllBenefits(); }
    @GetMapping("/{id}")
    private List<UserBenefits> getAllBenefitsByIdUserMain(@PathVariable String id){ return userBenefitsService.getUserBenefitsByIdUserMain(id); }
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserBenefits userBenefits, @PathVariable String id){ userBenefitsService.addAnUserBenefit(userBenefits, id); }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String id){ userBenefitsService.deleteAnBenefit(id); }
}
