package com.example.apiSuarezPharma.repository;


import com.example.apiSuarezPharma.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT p FROM User p WHERE p.firstName LIKE %:name% or p.lastName LIKE %:name%")
    List<User> getUserByName(String name);
    @Query(value = "SELECT p FROM User p INNER JOIN Membership m ON p.id = m.membershipUser.id")
    List<User> getAllUsersWithStatus();
    @Query(value = "SELECT p FROM User p WHERE p.id =:id AND p.password=:password")
    User loginUser (String id, String password);

}
