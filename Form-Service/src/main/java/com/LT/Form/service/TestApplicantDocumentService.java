package com.LT.Form.service;

import java.util.List;

import com.LT.Form.entity.TestApplicantDocument;

/**
 * Shows the list of services provided in JobAplicantInfo management
 * 
 * @author Mukund
 * @version 1.0
 *
 */

public interface TestApplicantDocumentService {

    List<TestApplicantDocument> getTestApplicantDocumentsByApplicantId(Long applicantId) throws Exception;

    TestApplicantDocument getDocument(String fileId) throws Exception;
}
