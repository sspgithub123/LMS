package com.bridgelabz.lms.model;


import com.bridgelabz.lms.dto.BankInfoDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="bank_info")
@Data
public class BankInfo {

//    @Transient
//    public static final String SEQUENCE_NAME = "bankId_sequence";
//
//    @Id
//    private long id;
    private String bankName;
    private String bankAccountNumber;
    private String ifscCode;
    private String branchName;

    public BankInfo() {
        super();
    }

    public BankInfo(BankInfoDTO bankInfoDto) {
        this.bankName = bankInfoDto.getBankName();
        this.bankAccountNumber = bankInfoDto.getBankAccountNumber();
        this.ifscCode = bankInfoDto.getIfscCode();
        this.branchName = bankInfoDto.getBranchName();
    }
}

