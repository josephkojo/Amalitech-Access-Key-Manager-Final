package com.springDevelopers.Backend.Controllers;

import com.springDevelopers.Backend.DTO.MailBody;
import com.springDevelopers.Backend.Entities.ForgotPassword;
import com.springDevelopers.Backend.Entities.User;
import com.springDevelopers.Backend.Repositories.ForgotPasswordRepository;
import com.springDevelopers.Backend.Repositories.UserRepository;
import com.springDevelopers.Backend.Services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/forgotPassword")
public class ChangePasswordController {
    private final PasswordEncoder passwordEncoder;
    private final ForgotPasswordRepository forgotPasswordRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;

    @PostMapping("/{email}")
    public ResponseEntity<String> verifyEmail(@PathVariable String email){
        try{
            User user = userRepository.findByEmail(email).orElseThrow(() ->
                    new UsernameNotFoundException("user email does not exist"));
            if(user == null){
                return ResponseEntity.notFound().build();
            }
            Integer code = generateVerificationCode();
            MailBody mailBody =  new MailBody();
            mailBody.setRecipient(email);
            mailBody.setText("Please enter this verification code to reset Account "+ code);
            mailBody.setSubject("ForgotPassword");
            ForgotPassword forgotPassword = new ForgotPassword();
            forgotPassword.setOtp(code);
            forgotPassword.setExpirationDate(new Date(System.currentTimeMillis() + 70000 * 1000));
            forgotPassword.setUser(user);
            emailService.simpleMailSender(mailBody);
            this.forgotPasswordRepository.save(forgotPassword);

            return new ResponseEntity<>("Verification has been successfully sent", HttpStatus.OK);
        }catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());

        }

    }




    private Integer generateVerificationCode(){
        Random random = new Random();
        return random.nextInt(100_000, 999_999);
    }


}
