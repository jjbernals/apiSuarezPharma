package com.example.apiSuarezPharma.service;


import com.example.apiSuarezPharma.entity.Membership;
import com.example.apiSuarezPharma.entity.User;
import com.example.apiSuarezPharma.exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import com.example.apiSuarezPharma.repository.MembershipRepository;
import com.example.apiSuarezPharma.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MembershipServiceImpl implements MembershipService{
    private final MembershipRepository membershipRepository;
    private final UserRepository userRepository;

    public MembershipServiceImpl(MembershipRepository membershipRepository, UserRepository userRepository) {
        this.membershipRepository = membershipRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createMembership(Membership membership, String id) {
        LocalDateTime date = LocalDateTime.now();
        membership.setStartMembership(date);
        date = LocalDateTime
                .of(date.getYear()+1, date.getMonth(), date.getDayOfMonth(), date.getHour(), date.getMinute());

        membership.setEndMembership(date);
        User user = userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("El usuario no fue encontrado"));

        membership.setMembershipUser(user);

        System.out.println("membership = " + membership);
        membershipRepository.save(membership);
    }

    @Override
    public Membership getMembershipByIdUser(String id) {
        return membershipRepository.getMembershipByIdUser(id);
    }

    @Override
    public List<Membership> getAllMembership() {
        return membershipRepository.findAll();
    }
}
