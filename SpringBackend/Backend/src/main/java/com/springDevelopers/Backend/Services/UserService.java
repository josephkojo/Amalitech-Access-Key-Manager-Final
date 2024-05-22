package com.springDevelopers.Backend.Services;

import com.springDevelopers.Backend.Entities.User;
import com.springDevelopers.Backend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findUserByEmail(String email){
        Optional<User> user = this.userRepository.findByEmail(email);
        return user.orElse(null);
    }
}
