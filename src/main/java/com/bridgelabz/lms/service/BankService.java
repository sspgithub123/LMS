//package com.bridgelabz.lms.service;
//
//import com.bridgelabz.lms.dto.BankInfoDTO;
//import com.bridgelabz.lms.model.BankInfo;
//import com.bridgelabz.lms.repository.BankRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class BankService implements IBankService{
//
//    @Autowired
//    BankRepository bankRepository;
//
//    @Autowired
//    SequenceGeneratorService sequenceGeneratorService;
//
//
//    @Override
//    public BankInfo addBankInfo(BankInfoDTO bankInfoDto) {
//        BankInfo bankInfo = new BankInfo(bankInfoDto);
//        bankInfo.setId(sequenceGeneratorService.generateSequence(BankInfo.SEQUENCE_NAME));
//        return bankRepository.save(bankInfo);
//    }
//
//    @Override
//    public List<BankInfo> getAllBankDeatils() {
//        List<BankInfo> bankInfoList = bankRepository.findAll();
//        return bankInfoList;
//    }
//
//    @Override
//    public BankInfo updateBankInfo(long id, BankInfoDTO bankInfoDto) {
//        Optional<BankInfo> bankInfo = bankRepository.findById(id);
//        if (bankInfo.isPresent()) {
//            bankInfo.get().setBankName(bankInfoDto.getBankName());
//            bankInfo.get().setBankAccountNumber(bankInfoDto.getBankAccountNumber());
//            bankInfo.get().setIfscCode(bankInfoDto.getIfscCode());
//            bankInfo.get().setBranchName(bankInfoDto.getBranchName());
//
//        }
//        return bankRepository.save(bankInfo.get());
//    }
//}
