package com.example.apiSuarezPharma.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "membership")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean status;
    private LocalDateTime startMembership;
    private LocalDateTime endMembership;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User membershipUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getStartMembership() {
        return startMembership;
    }

    public void setStartMembership(LocalDateTime startMembership) {
        this.startMembership = startMembership;
    }

    public LocalDateTime getEndMembership() {
        return endMembership;
    }

    public void setEndMembership(LocalDateTime endMembership) {
        this.endMembership = endMembership;
    }

    public User getMembershipUser() {
        return membershipUser;
    }

    public void setMembershipUser(User membershipUser) {
        this.membershipUser = membershipUser;
    }

}
