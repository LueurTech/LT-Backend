package com.LT.Form.service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.Form.entity.TestApplicantDocument;
import com.LT.Form.repository.TestApplicantDocumentRepository;
import com.LT.Form.service.TestApplicantDocumentService;

/**
 * Implementation class of TestApplicantDocument service
 * 
 * @author Mukund
 * @version 1.0
 *
 */

@Service
public class TestApplicantDocumentServiceImpl implements TestApplicantDocumentService {

    @Autowired
    TestApplicantDocumentRepository testApplicantDocumentRepository;

    @Override
    public List<TestApplicantDocument> getTestApplicantDocumentsByApplicantId(Long applicantId) throws Exception {
        if (applicantId == null) {
            throw new RemoteException("applicantId can't be empty");
        }
        return testApplicantDocumentRepository.findByTestApplicantInfoId(applicantId);
    }

    @Override
    public TestApplicantDocument getDocument(String fileId) throws Exception {
        return testApplicantDocumentRepository.findById(fileId).orElseThrow(() -> new Exception("ERROR NOT FOUND"));
    }

}
