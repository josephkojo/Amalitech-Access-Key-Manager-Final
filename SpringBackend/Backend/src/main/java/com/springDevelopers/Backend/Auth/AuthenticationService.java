package com.springDevelopers.Backend.Auth;

import com.springDevelopers.Backend.Entities.User;
import com.springDevelopers.Backend.Enums.Role;
import com.springDevelopers.Backend.Repositories.UserRepository;
import com.springDevelopers.Backend.Services.UserService;
import com.springDevelopers.Backend.SpringSecurity.JwtService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    public AuthenticateResponse registerUser(RegisterRequest registerRequest){
        User user = new User();
        user.setFirstname(registerRequest.getFirstname());
        user.setLastname(registerRequest.getLastname());
        user.setSchoolEmail(registerRequest.getSchoolEmail());
        user.setEmail(registerRequest.getEmail());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        this.userRepository.save(user);
        String token = jwtService.generateToken(user);
        AuthenticateResponse authenticateResponse = new AuthenticateResponse();
        authenticateResponse.setId(user.getId());
        authenticateResponse.setFirstname(user.getFirstname());
        authenticateResponse.setEmail(user.getEmail());
        authenticateResponse.setRole(user.getRole().toString());
        authenticateResponse.setToken(token);

        return authenticateResponse;
    }

    @PostConstruct
    public AuthenticateResponse registerAdmin(){
        User user = new User();
        user.setFirstname("Isaac");
        user.setLastname("Asante");
        user.setSchoolEmail("bompeh@gmail.com");
        user.setEmail("mosesmensah081@gmail.com");
        user.setRole(Role.ADMIN);
        user.setPassword(passwordEncoder.encode("ebo"));
        this.userRepository.save(user);
        String token = jwtService.generateToken(user);
        AuthenticateResponse authenticateResponse = new AuthenticateResponse();
        authenticateResponse.setId(user.getId());
        authenticateResponse.setFirstname(user.getFirstname());
        authenticateResponse.setEmail(user.getEmail());
        authenticateResponse.setRole(user.getRole().toString());
        authenticateResponse.setToken(token);
        return authenticateResponse;

    }
    public AuthenticateResponse loginUser(AuthenticateRequest authenticateRequest){
        if(authenticateRequest.getEmail().equals("mosesmensah081@gmail.com") && authenticateRequest.getPassword().equals("ebo") ){
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getEmail(),
                    authenticateRequest.getPassword()));
            User user = this.userRepository.findByEmail(authenticateRequest.getEmail()).orElseThrow();
            String token = this.jwtService.generateToken(user);
            AuthenticateResponse authenticateResponse = new AuthenticateResponse();
            authenticateResponse.setId(user.getId());
            authenticateResponse.setFirstname(user.getFirstname());
            authenticateResponse.setEmail(user.getEmail());
            authenticateResponse.setRole(user.getRole().toString());
            authenticateResponse.setToken(token);
            return authenticateResponse;



        }else{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getEmail(),
                    authenticateRequest.getPassword()));
            User user = this.userRepository.findByEmail(authenticateRequest.getEmail()).orElseThrow();
            String token = this.jwtService.generateToken(user);
            AuthenticateResponse authenticateResponse = new AuthenticateResponse();
            authenticateResponse.setId(user.getId());
            authenticateResponse.setFirstname(user.getFirstname());
            authenticateResponse.setEmail(user.getEmail());
            authenticateResponse.setRole(user.getRole().toString());
            authenticateResponse.setToken(token);
            return authenticateResponse;

        }


    }




}
