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

import com.LT.Form.entity.TestApplicantDocument;
import com.LT.Form.service.TestApplicantDocumentService;
import com.LT.Form.util.GenericController;

@RequestMapping("/form/testApplicant")
@RestController
public class TestApplicantDocumentController extends GenericController {

    private static Logger logger = LoggerFactory.getLogger(TestApplicantDocumentController.class);

    @Autowired
    private TestApplicantDocumentService testApplicantDocumentService;

    @GetMapping("/document/{applicantId}")
    public ResponseEntity<?> listInternDocumentsByInternId(@PathVariable Long applicantId) throws Exception {
        try {
            logger.info("inside get InternInfo");

            List<TestApplicantDocument> internDocuments = this.testApplicantDocumentService
                    .getTestApplicantDocumentsByApplicantId(applicantId);
            return SUCCESS(internDocuments);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to get Intern info", e);
            return FAILURE(e.getMessage());
        }

    }
}
