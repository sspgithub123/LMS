//package com.bridgelabz.lms.controller;
//
//
//import com.bridgelabz.lms.dto.QualificationDTO;
//import com.bridgelabz.lms.dto.ResponseDTO;
//import com.bridgelabz.lms.model.QualificationInfo;
//import com.bridgelabz.lms.service.IQualificationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/candidateQualification")
//public class QualificationController {
//
//    @Autowired
//    IQualificationService iQualificationService;
//
//    /**
//     * Ability to call api to insert qualification record
//     * @param qualificationDto- represents object of qualificationDto class
//     * @return- accepted q information in JSON format
//     * @apiNote accepts the data in JSON format and stores it in DB
//     */
//    @PostMapping("/addQualification")
//    public ResponseEntity<ResponseDTO> addQualification(@RequestBody QualificationDTO qualificationDto) {
//        QualificationInfo qualificationInfo = iQualificationService.addQualificationData(qualificationDto);
//        ResponseDTO responseDTO = new ResponseDTO("Candidate qualification is added..",qualificationInfo);
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
//
//    @GetMapping("/getQualificationData")
//    public ResponseEntity<ResponseDTO> getQualificationData(){
//        List<QualificationInfo> list = iQualificationService.getQualificationData();
//        ResponseDTO responseDTO = new ResponseDTO("List of all qualification candidate", list);
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
//
//    @PutMapping("/updateQualificationById/{id}")
//    public ResponseEntity<ResponseDTO> updateQualification(@PathVariable long id, @RequestBody QualificationDTO qualificationDto){
//        QualificationInfo qualificationInfo = iQualificationService.updateQualificationById(id, qualificationDto);
//        ResponseDTO responseDTO = new ResponseDTO("Qualification data successfully updated..", qualificationInfo);
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
//}
