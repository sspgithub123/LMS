package com.bridgelabz.lms.dto;

import com.bridgelabz.lms.model.BankInfo;
import com.bridgelabz.lms.model.QualificationInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CandidateDTO
{
    private String firstName;
    private String lastName;
    private String status;
    private String email;
    private long mobileNumber;
    private String city;
    private BankInfo bankInfo;
    private QualificationInfo qualificationInfo;

}
