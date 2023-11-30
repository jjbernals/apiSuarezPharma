package com.example.apiSuarezPharma.controller;


import com.example.apiSuarezPharma.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.apiSuarezPharma.service.UserServiceImpl;

import javax.security.sasl.AuthenticationException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){ return userService.getAllUser(); }
    @GetMapping("/test-api")
    public String testApi (){return "Hola, bienvenido a la aplicacion, esto es una carga de ejemplo";}

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){ return userService.getUserById(id); }

    @GetMapping("/status")
    public List<User> getAllUsersWithStatus(){ return userService.getAllUsersWithStatus(); }

    @GetMapping("/search={name}")
    public List<User> getUserByName(@PathVariable String name){ return userService.getUserByName(name); }
    @GetMapping("/{id}/{password}")
    public User loginUser(@PathVariable String id, @PathVariable String password) throws AuthenticationException { return userService.loginUser(id, password); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){ userService.createUser(user); }

    @PatchMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUserById(@PathVariable String id, @RequestBody User user){ userService.updateUser(user, id); }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable String id){ userService.deleteUser(id); }

}
