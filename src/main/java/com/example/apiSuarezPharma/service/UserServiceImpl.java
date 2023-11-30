package com.example.apiSuarezPharma.service;

import com.example.apiSuarezPharma.entity.Membership;
import com.example.apiSuarezPharma.entity.User;
import com.example.apiSuarezPharma.exception.UserFoundException;
import com.example.apiSuarezPharma.exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import com.example.apiSuarezPharma.repository.MembershipRepository;
import com.example.apiSuarezPharma.repository.UserRepository;

import javax.security.sasl.AuthenticationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MembershipRepository membershipRepository;

    public UserServiceImpl(UserRepository userRepository, MembershipRepository membershipRepository) {
        this.userRepository = userRepository;
        this.membershipRepository = membershipRepository;
    }

    @Override
    public void createUser(User user) {
        Optional<User> userRepeat = userRepository.findById(user.getId());
        if(userRepeat.isEmpty()){
            userRepository.save(user);
        }else{
            throw new UserFoundException("El usuario ya se encuentra registrado");
        }
    }

    @Override
    public void updateUser(User user, String id) {
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("El usuario con el documento " + id + " no se encuentra registrado"));
        Membership membershipUser = membershipRepository.getMembershipByIdUser(user.getId());
        if(membershipUser != null){
            membershipRepository.delete(membershipUser);
        }
        userRepository.delete(user);
    }

    @Override
    public User loginUser(String id, String password) throws AuthenticationException {
        User user = userRepository.loginUser(id, password);
        if(user!= null){
            return user;
        }
        throw new AuthenticationException("Credenciales inválidas");
    }

    @Override
    public User getUserById(String id) {

        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("El usuario no se encuentra registrado"));
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUserByName(String name) {
        return userRepository.getUserByName(name);
    }

    @Override
    public List<User> getAllUsersWithStatus() {
        return userRepository.getAllUsersWithStatus();
    }
}
