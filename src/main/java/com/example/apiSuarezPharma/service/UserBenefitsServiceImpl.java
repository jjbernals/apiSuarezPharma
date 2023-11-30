package com.example.apiSuarezPharma.service;


import com.example.apiSuarezPharma.entity.User;
import com.example.apiSuarezPharma.entity.UserBenefits;
import com.example.apiSuarezPharma.exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import com.example.apiSuarezPharma.repository.UserBenefitsRepository;
import com.example.apiSuarezPharma.repository.UserRepository;

import java.util.List;

@Service
public class UserBenefitsServiceImpl implements UserBenefitsService{
    private final UserBenefitsRepository userBenefitsRepository;
    private final UserRepository userRepository;

    public UserBenefitsServiceImpl(UserBenefitsRepository userBenefitsRepository, UserRepository userRepository) {
        this.userBenefitsRepository = userBenefitsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addAnUserBenefit(UserBenefits userBenefits, String id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("El usuario con cedula "+id+ " no fue encontrado"));
        userBenefits.setUserMain(user);
        userBenefitsRepository.save(userBenefits);
    }

    @Override
    public void deleteAnBenefit(String id) {
        userBenefitsRepository.deleteById(id);
    }

    @Override
    public List<UserBenefits> getUserBenefitsByIdUserMain(String id) {
        return userBenefitsRepository.getBenefitsByIdUserMain(id);
    }

    @Override
    public List<UserBenefits> getAllBenefits() {
        return userBenefitsRepository.findAll();
    }
}
