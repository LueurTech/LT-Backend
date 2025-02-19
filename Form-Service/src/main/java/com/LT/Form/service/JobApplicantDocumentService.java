package com.LT.Form.service;

import java.util.List;

import com.LT.Form.entity.JobApplicantDocument;

/**
 * Shows the list of services provided in JobAplicantInfo management
 * 
 * @author Mukund
 * @version 1.0
 *
 */

public interface JobApplicantDocumentService {

    List<JobApplicantDocument> getJobApplicantDocumentsByApplicantId(Long applicantId) throws Exception;

    JobApplicantDocument getDocument(String fileId) throws Exception;
}
