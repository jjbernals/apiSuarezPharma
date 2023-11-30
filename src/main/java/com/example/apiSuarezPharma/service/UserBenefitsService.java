package com.example.apiSuarezPharma.service;


import com.example.apiSuarezPharma.entity.UserBenefits;

import java.util.List;

public interface UserBenefitsService {
    void addAnUserBenefit(UserBenefits userBenefits, String id);
    void deleteAnBenefit(String id);
    List<UserBenefits> getUserBenefitsByIdUserMain(String id);
    List<UserBenefits> getAllBenefits ();
}
