package com.springDevelopers.Backend.DTO;

import lombok.Setter;

import java.time.LocalDate;


public class AccessKeysDTO {
    private  Integer Id;
    private String key;
    private String status;
    private LocalDate dateOfProcurement;
    private LocalDate expiryDate;

    public AccessKeysDTO(){

    }

    public AccessKeysDTO(Integer id, String key, String status, LocalDate dateOfProcurement, LocalDate expiryDate) {
        Id = id;
        this.key = key;
        this.status = status;
        this.dateOfProcurement = dateOfProcurement;
        this.expiryDate = expiryDate;
    }
}
