package com.springDevelopers.Backend.Services;

import com.springDevelopers.Backend.Entities.User;
import com.springDevelopers.Backend.Enums.Role;
import com.springDevelopers.Backend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private  final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findUserByEmail(String email){
        Optional<User> user = this.userRepository.findByEmail(email);
        return user.orElse(null);
    }
    public List<User> findAllUser(){
        List<User> findAllUser = this.userRepository.findAll();
        return findAllUser;
    }

    public User findByUserId(Integer Id){
        return userRepository.findById(Id).orElse(new User());
    }
    public User findUserBySchoolEmail(String schoolEmail){
        return this.userRepository.findUserBySchoolEmail(schoolEmail).orElse(new User());
    }
    public boolean adminExists() {
        return userRepository.existsByRole(Role.ADMIN);
    }
    public void registerAdmin() {
        User user = new User();
        user.setFirstname("Isaac");
        user.setLastname("Asante");
        user.setSchoolEmail("bompeh@gmail.com");
        user.setEmail("mosesmensah081@gmail.com");
        user.setRole(Role.ADMIN);
        user.setPassword(passwordEncoder.encode("ebo"));
        this.userRepository.save(user);
    }
}
