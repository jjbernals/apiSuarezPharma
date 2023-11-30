package com.example.apiSuarezPharma.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_benefits")
public class UserBenefits {
    @Id
    private String id;
    private String name;
    private String typeOfDocument;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User userMain;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUserMain() {
        return userMain;
    }

    public void setUserMain(User userMain) {
        this.userMain = userMain;
    }
}
