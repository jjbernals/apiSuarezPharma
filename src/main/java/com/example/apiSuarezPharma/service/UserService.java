package com.example.apiSuarezPharma.service;


import com.example.apiSuarezPharma.entity.User;

import javax.security.sasl.AuthenticationException;
import java.util.List;

public interface UserService {
    void createUser(User user);
    void updateUser(User user, String id);
    void deleteUser(String id);
    User loginUser(String id, String password) throws AuthenticationException;
    User getUserById(String id);
    List<User> getAllUser();
    List<User> getUserByName(String name);
    List<User> getAllUsersWithStatus();
}
