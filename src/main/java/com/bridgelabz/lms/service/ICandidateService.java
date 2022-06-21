package com.bridgelabz.lms.service;

import com.bridgelabz.lms.dto.CandidateDTO;
import com.bridgelabz.lms.model.Candidate;

import java.util.List;

public interface ICandidateService {

    String createCandidate(CandidateDTO candidateDTO);
    List<Candidate> getAll();
    Candidate getById(long candidateId);
    List<Candidate>  hiredCandidate(String status);

    Candidate updateCandidate(String token, CandidateDTO hiredCandidateDto);

    long count1(String status);

    Candidate updateStatus(String token, CandidateDTO hiredCandidateDto);

    Candidate jobOfferMail(String token);

}

