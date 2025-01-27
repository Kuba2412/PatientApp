package com.Kuba2412.PatientApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;
    private String email;
}
