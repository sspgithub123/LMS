package com.bridgelabz.lms.service;

import com.bridgelabz.lms.dto.CandidateDTO;
import com.bridgelabz.lms.exception.CandidateException;
import com.bridgelabz.lms.model.Candidate;
import com.bridgelabz.lms.repository.CandidateRepository;
import com.bridgelabz.lms.util.EmailSenderService;
import com.bridgelabz.lms.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements ICandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    EmailSenderService sender;

    @Autowired
    TokenUtil tokenUtil;

    public String createCandidate(CandidateDTO candidateDTO) {
        Candidate candidate = new Candidate(candidateDTO);
        candidate.setId(sequenceGeneratorService.generateSequence(Candidate.SEQUENCE_NAME));
        candidateRepository.save(candidate);
        String token = tokenUtil.createToken((int) candidate.getId());
        sender.sendEmail(candidate.getEmail(), "Test Email", "Candidate added SuccessFully, hii: "
                +candidate.getFirstName()+"Please Click here to get data-> "
                +"http://localhost:9090/user/getBy/"+token);
        return token;
    }

    @Override
    public List<Candidate> getAll() {
        List<Candidate> getCandidates = candidateRepository.findAll();
        if (getCandidates.isEmpty()) {
            throw new CandidateException(HttpStatus.NOT_FOUND, "There is not data added yet!!");
        } else
            return getCandidates;
    }

    @Override
    public Candidate getById(long candidateId) {
        Optional<Candidate> candidate = candidateRepository.findById(candidateId);
        if (candidate.isPresent()) {
            return candidate.get();
        } else
            throw new CandidateException(HttpStatus.NOT_FOUND, "This Id is not found! ");
    }

    @Override
    public List<Candidate> hiredCandidate(String status) {
        List<Candidate>candidate = candidateRepository.findCandidateByStatus(status);
        if (candidate.isEmpty()) {
            throw new CandidateException(HttpStatus.NOT_FOUND, "There are no candidate got hired yet!!");
        }
        return candidate;
    }

    @Override
    public Candidate updateCandidate(String token, CandidateDTO candidateDTO) {
        long id = tokenUtil.decodeToken(token);
        Optional<Candidate> hiredCandidate = candidateRepository.findById(id);
        if (hiredCandidate.isPresent()){
            hiredCandidate.get().setFirstName(candidateDTO.getFirstName());
            hiredCandidate.get().setLastName(candidateDTO.getLastName());
            hiredCandidate.get().setEmail(candidateDTO.getEmail());
            hiredCandidate.get().setMobileNumber(candidateDTO.getMobileNumber());
            hiredCandidate.get().setStatus(candidateDTO.getStatus());
            hiredCandidate.get().setCity(candidateDTO.getCity());
            hiredCandidate.get().setQualificationInfo(candidateDTO.getQualificationInfo());
            hiredCandidate.get().setBankInfo(candidateDTO.getBankInfo());
        }
        return candidateRepository.save(hiredCandidate.get());
    }

    @Override
    public long count1(String status) {
        return candidateRepository.countByStatusEquals(status);
    }

    @Override
    public Candidate updateStatus(String token, CandidateDTO candidateDTO) {
        long id = tokenUtil.decodeToken(token);
        Optional<Candidate> updateStatus = candidateRepository.findById(id);
        updateStatus.get().setStatus(candidateDTO.getStatus());
        return candidateRepository.save(updateStatus.get());
    }

    @Override
    public Candidate jobOfferMail(String token) {
        long id = tokenUtil.decodeToken(token);
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isPresent()){
            sender.sendEmail(candidate.get().getEmail(), "Job Offer", " Hi " +
                    candidate.get().getFirstName()
                    + "\n You have been selected as the best candidate for the " +
                    "software engineer position. Congratulations!");

        }
        return candidate.get();
    }

}
