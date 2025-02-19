package com.LT.Form.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LT.Form.entity.JobApplicantDocument;
import com.LT.Form.service.JobApplicantDocumentService;
import com.LT.Form.util.GenericController;

@RequestMapping("/form/jobApplicant")
@RestController
public class JobApplicantDocumentController extends GenericController {

    private static Logger logger = LoggerFactory.getLogger(JobApplicantDocumentController.class);

    @Autowired
    private JobApplicantDocumentService jobApplicantDocumentService;

    @GetMapping("/document/{jobApplicantId}")
    public ResponseEntity<?> listInternDocumentsByInternId(@PathVariable Long jobApplicantId) throws Exception {
        try {
            logger.info("inside get InternInfo");

            List<JobApplicantDocument> internDocuments = this.jobApplicantDocumentService
                    .getJobApplicantDocumentsByApplicantId(
                            jobApplicantId);
            return SUCCESS(internDocuments);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to get Intern info", e);
            return FAILURE(e.getMessage());
        }

    }
}
