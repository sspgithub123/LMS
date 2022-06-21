package com.bridgelabz.lms.controller;

import com.bridgelabz.lms.dto.CandidateDTO;
import com.bridgelabz.lms.dto.ResponseDTO;
import com.bridgelabz.lms.model.Candidate;
import com.bridgelabz.lms.service.CandidateService;
import com.bridgelabz.lms.service.ICandidateService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * In Controller class we write the API's here
 */
@RestController
@RequestMapping("/candidateDetails")
public class CandidateController {

    /**
     * Autowired IBookService to inject its dependency here
     */
    @Autowired
    private ICandidateService iCandidateService;
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @PostMapping("/importCustomers")
    public void importCsvToDBJob() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis()).toJobParameters();
        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ability to call api to insert Book record
     * @param candidateDTO- represents object of CandidateDTO class
     * @return- accepted book information in JSON format
     * @apiNote accepts the data in JSON format and stores it in DB
     */
    @PostMapping("/addCandidate")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody CandidateDTO candidateDTO) {
        String Candidate = iCandidateService.createCandidate(candidateDTO);
        ResponseDTO responseDto = new ResponseDTO("Candidate Added Successfully !!!", Candidate);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Ability to call api to retrieve all Candidate records
     * @return- return all stored data with message
     */
    @GetMapping(value = "/getAll")
    public ResponseEntity<String> getAll() {
        List<Candidate> listOfUsers = iCandidateService.getAll();
        ResponseDTO responseDto = new ResponseDTO("Candidate retrieved successfully !!!", listOfUsers);
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }

    /**
     * Ability to call api to get record by CandidateId
     * @param CandidateId -represents CandidateId
     * @return -return all stored data with message
     */
    @GetMapping("/findById/{candidateId}")
    ResponseEntity<ResponseDTO> getById(@PathVariable long candidateId) {
        Candidate candidate = iCandidateService.getById(candidateId);
        ResponseDTO responseDto = new ResponseDTO("Candidate Id found", candidate);
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }

    /**
     * Ability to call api to get record by CandidateStatus
     * @param status -represents CandidateStatus
     * @return -return all stored data with message
     */
    @GetMapping("/get/{status}")
    public ResponseEntity<ResponseDTO> getHiredCandidatesNotHiredCandidates(@PathVariable String status) {
        List candidate = iCandidateService.hiredCandidate(status);
        ResponseDTO responseDto = new ResponseDTO("Requested HiredCandidate or Not HiredCandidate !!!", candidate);
        return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
    }

    /**
     * Ability to call api to update Candidate record by CandidateToken
     * @param token -represents CandidateToken
     * @param hiredCandidateDto represents object of CandidateDto class
     * @return -return updated information
     */
    @PutMapping("/updateBy/{token}")
    public ResponseEntity<ResponseDTO> updateCandidateData(@PathVariable String token,
                                                           @RequestBody CandidateDTO hiredCandidateDto) {
        Candidate hiredCandidate = iCandidateService.updateCandidate(token, hiredCandidateDto);
        ResponseDTO response = new ResponseDTO("Update candidate data successfully !!!", hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Ability to call api to get count by CandidateStatus
     * @param status -represents CandidateStatus
     * @return -return all stored data with message
     */
    @GetMapping("/count/{status}")
    public ResponseEntity<ResponseDTO> getCount (@PathVariable String status){
        long candidate = iCandidateService.count1(status);
        ResponseDTO response = new ResponseDTO("Candidates Count !!!",candidate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Ability to call api to update Candidate record by CandidateToken
     * @param token -represents CandidateToken
     * @param candidateDTO represents object of candidateDTO class
     * @return -return updated information
     */
    @PutMapping("/updateStatus/{token}")
    public ResponseEntity<ResponseDTO> getStatusByToken(@PathVariable String token, @RequestBody CandidateDTO candidateDTO){
        Candidate candidate = iCandidateService.updateStatus(token, candidateDTO);
        ResponseDTO responseDto = new ResponseDTO("Candidate Status Updated !!!", candidate);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Ability to call api to send Offer record
     * @param token- represents object of CandidateDTO class
     * @return -return jobOfferMail
     */
    @PostMapping("/jobofferMail/{token}")
    public ResponseEntity<ResponseDTO> sendOffer(@PathVariable String token){
        Candidate candidate = iCandidateService.jobOfferMail(token);
        ResponseDTO responseDto = new ResponseDTO("Email send successfully !!!", candidate);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}