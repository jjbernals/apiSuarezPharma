package com.example.apiSuarezPharma.repository;


import com.example.apiSuarezPharma.entity.UserBenefits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserBenefitsRepository extends JpaRepository<UserBenefits, String> {
    @Query(value = "SELECT p FROM UserBenefits p WHERE p.userMain.id =:id ")
    List<UserBenefits> getBenefitsByIdUserMain(String id);

}
