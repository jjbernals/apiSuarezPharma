package com.example.apiSuarezPharma.service;


import com.example.apiSuarezPharma.entity.Membership;

import java.util.List;

public interface MembershipService {
    void createMembership (Membership membership, String id);
    Membership getMembershipByIdUser(String id);
    List<Membership> getAllMembership();
}
