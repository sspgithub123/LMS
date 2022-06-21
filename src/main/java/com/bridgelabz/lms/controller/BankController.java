//package com.bridgelabz.lms.controller;
//
//
//import com.bridgelabz.lms.dto.BankInfoDTO;
//import com.bridgelabz.lms.dto.ResponseDTO;
//import com.bridgelabz.lms.model.BankInfo;
//import com.bridgelabz.lms.service.IBankService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * In Controller class we write the API's here
// */
//@RestController
//@RequestMapping("/bankInfo")
//public class BankController {
//
//    /**
//     * Autowired IBookService to inject its dependency here
//     */
//    @Autowired
//    IBankService iBankService;
//
//    /**
//     * Ability to call api to insert bank record
//     * @param bankInfoDto- represents object of BankInfoDTO class
//     * @return- accepted book information in JSON format
//     * @apiNote accepts the data in JSON format and stores it in DB
//     */
//    @PostMapping("/addData")
//    public ResponseEntity<ResponseDTO> addingBankDetails(@RequestBody BankInfoDTO bankInfoDto) {
//        BankInfo bank = iBankService.addBankInfo(bankInfoDto);
//        ResponseDTO responseDTO = new ResponseDTO("Bank Info Added Successfully !!!", bank);
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
//
//    /**
//     * Ability to call api to retrieve all bank records
//     * @return- return all stored data with message
//     */
//    @GetMapping("/getallbankDetails")
//    public ResponseEntity<ResponseDTO> getDetails() {
//        List<BankInfo> list = iBankService.getAllBankDeatils();
//        ResponseDTO responseDTO = new ResponseDTO("Bank Details !!!", list);
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
//
//    /**
//     * Ability to call api to update book record by bankId
//     * @param id -represents BankId
//     * @param bankInfoDto represents object of bankInfoDto class
//     * @return -return updated information
//     */
//    @PutMapping("/updatebankdetails/{id}")
//    public ResponseEntity<ResponseDTO> updateInfo(@PathVariable long id, @RequestBody BankInfoDTO bankInfoDto) {
//        BankInfo bank = iBankService.updateBankInfo(id, bankInfoDto);
//        ResponseDTO responseDTO = new ResponseDTO("Bank Data Successfully Updated !!!", bank);
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
//
//}
