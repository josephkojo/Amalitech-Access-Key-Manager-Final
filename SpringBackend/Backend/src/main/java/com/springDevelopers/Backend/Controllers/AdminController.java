package com.springDevelopers.Backend.Controllers;

import com.springDevelopers.Backend.DTO.AccessKeyDTO;
import com.springDevelopers.Backend.Entities.AccessKey;
import com.springDevelopers.Backend.Entities.User;
import com.springDevelopers.Backend.Enums.Status;
import com.springDevelopers.Backend.Services.AccessKeyService;
import com.springDevelopers.Backend.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AccessKeyService accessKeyService;
    private final UserService userService;
    @GetMapping("/getAllKeys")
    public ResponseEntity<List<AccessKeyDTO>> getAllKeysGenerated(){
        List<AccessKeyDTO> accessKeyDTOList = this.accessKeyService.getAllAccessKeys();
        return new ResponseEntity<>(accessKeyDTOList, HttpStatus.OK);
    }

    @GetMapping("/getActiveKey/{email}")
    public ResponseEntity<AccessKey> getActiveKey(@PathVariable String email){
        User user = this.userService.findUserBySchoolEmail(email);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        List<AccessKey> accessKeyList = this.accessKeyService.getAllAccessKeyByUser(user);
        AccessKey activeAccessKey = null;
        for(AccessKey accessKey: accessKeyList){
            if(accessKey.getStatus() == Status.ACTIVE){
                activeAccessKey = accessKey;
            }
        }
        return activeAccessKey == null ? ResponseEntity.status(404).build() : new ResponseEntity<>(activeAccessKey, HttpStatusCode.valueOf(200));



    }
}
