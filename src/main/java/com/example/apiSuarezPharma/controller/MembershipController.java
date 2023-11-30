package com.example.apiSuarezPharma.controller;


import com.example.apiSuarezPharma.entity.Membership;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.apiSuarezPharma.service.MembershipServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/membership")
public class MembershipController {
    private final MembershipServiceImpl membershipService;

    public MembershipController(MembershipServiceImpl membershipService) {
        this.membershipService = membershipService;
    }

    @GetMapping
    public List<Membership> getAllMembership(){ return membershipService.getAllMembership(); }

    @GetMapping("/user/{id}")
    public Membership getMembershipByIdUser(@PathVariable String id){ return membershipService.getMembershipByIdUser(id); }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMembershipForUser(@PathVariable String id, @RequestBody Membership membership){ membershipService.createMembership(membership, id); }
}
