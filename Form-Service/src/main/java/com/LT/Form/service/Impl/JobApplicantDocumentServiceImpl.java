package com.LT.Form.service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.Form.entity.JobApplicantDocument;
import com.LT.Form.repository.JobApplicantDocumentRepository;
import com.LT.Form.service.JobApplicantDocumentService;

/**
 * Implementation class of JobApplicantInfo service
 * 
 * @author Mukund
 * @version 1.0
 *
 */

@Service
public class JobApplicantDocumentServiceImpl implements JobApplicantDocumentService {

    @Autowired
    JobApplicantDocumentRepository jobApplicantDocumentRepository;

    @Override
    public List<JobApplicantDocument> getJobApplicantDocumentsByApplicantId(Long applicantId) throws Exception {
        if (applicantId == null) {
            throw new RemoteException("applicantId can't be empty");
        }
        return jobApplicantDocumentRepository.findByJobApplicantInfoId(applicantId);
    }

    @Override
    public JobApplicantDocument getDocument(String fileId) throws Exception {
        return jobApplicantDocumentRepository.findById(fileId).orElseThrow(() -> new Exception("ERROR NOT FOUND"));
    }

}
