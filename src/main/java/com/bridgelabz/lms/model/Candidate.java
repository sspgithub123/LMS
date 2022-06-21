package com.bridgelabz.lms.model;

import com.bridgelabz.lms.dto.BankInfoDTO;
import com.bridgelabz.lms.dto.CandidateDTO;
import com.bridgelabz.lms.dto.QualificationDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;

@Data
@Document(collection = "Candidate")
public class Candidate {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private long id;

    private String firstName;
    private String lastName;
    private String status;
    private String email;
    private long mobileNumber;
    private String city;

    private BankInfo bankInfo;

    private QualificationInfo qualificationInfo;


    public Candidate(CandidateDTO dto) {
        super();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.status = dto.getStatus();
        this.email = dto.getEmail();
        this.mobileNumber = dto.getMobileNumber();
        this.city = dto.getCity();
        this.bankInfo = dto.getBankInfo();
        this.qualificationInfo = dto.getQualificationInfo();


    }

    public Candidate(long id, CandidateDTO candidateDTO) {

        this.firstName = candidateDTO.getFirstName();
        this.lastName = candidateDTO.getLastName();
        this.status = candidateDTO.getStatus();
        this.email = candidateDTO.getEmail();
        this.mobileNumber = candidateDTO.getMobileNumber();
        this.city = candidateDTO.getCity();
    }

    public Candidate() {
        super();
    }

    public Candidate(long id, Optional<Candidate> candidate) {

    }
}
