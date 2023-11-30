package com.example.apiSuarezPharma.repository;


import com.example.apiSuarezPharma.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
    @Query(value = "SELECT p FROM Membership p WHERE p.membershipUser.id =:id")
    Membership getMembershipByIdUser(String id);
}
