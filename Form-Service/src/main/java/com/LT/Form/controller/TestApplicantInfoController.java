package com.LT.Form.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.LT.Form.dto.TestApplicantMarksRequest;
import com.LT.Form.entity.TestApplicantDocument;
import com.LT.Form.entity.TestApplicantInfo;
import com.LT.Form.service.TestApplicantInfoService;
import com.LT.Form.util.GenericController;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller class to handle the TestApplicantInfo related operations
 * 
 * @author Mukund
 * @version 1.0
 */

@RestController
@RequestMapping("/form/testApplicant")
@Slf4j
public class TestApplicantInfoController extends GenericController {
    private static Logger logger = LoggerFactory.getLogger(TestApplicantInfoController.class);

    @Autowired
    private TestApplicantInfoService service;

    @PostMapping(value = "/add")
    public ResponseEntity<?> addTestApplicantInfo(@RequestPart("documents") MultipartFile[] documents,
            @RequestPart("data") String jsonData) {
        TestApplicantInfo testApplicantInfo = null;
        try {
            logger.info("Inside add TestApplicantInfo");

            ObjectMapper objectMapper = new ObjectMapper();
            testApplicantInfo = objectMapper.readValue(jsonData,
                    TestApplicantInfo.class);
            TestApplicantDocument testApplicantDocument = null;
            for (MultipartFile document : documents) {
                String fileName = StringUtils.cleanPath(document.getOriginalFilename());

                testApplicantDocument = new TestApplicantDocument();
                testApplicantDocument.setFileName(fileName);
                testApplicantDocument.setFileType(document.getContentType());
                testApplicantDocument.setData(document.getBytes());

                testApplicantInfo.addDocument(testApplicantDocument);
            }

            this.service.addTestApplicantInfo(testApplicantInfo);
            return SUCCESS(testApplicantInfo);
        } catch (Exception e) {
            e.printStackTrace();

            String msg = e.getMessage();
            logger.error("Unable to add", e);
            // if (msg != null && msg.contains("ConstraintViolationException"))
            // msg = testApplicantInfo.getPhoneNo() + " already present in the system";
            return FAILURE(msg);

        }
    }

    @PostMapping(path = "/updateMarks")
    public ResponseEntity<?> updateTestApplicantMarks(@RequestBody TestApplicantMarksRequest marksRequest) {
        try {
            logger.info("inside update TestApplicantMarks");
            TestApplicantInfo testApplicantInfo = this.service.updateTestApplicantMarks(marksRequest);
            return SUCCESS(testApplicantInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to update TestApplicant Marks", e);
            return FAILURE(e.getMessage());
        }
    }

    @PostMapping(path = "/update")
    public ResponseEntity<?> updateTestApplicantInfo(@RequestBody TestApplicantInfo testApplicantInfo) {
        try {
            logger.info("inside update TestApplicantInfo");
            this.service.updateTestApplicantInfo(testApplicantInfo);
            return SUCCESS(testApplicantInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to update TestApplicantInfo", e);
            return FAILURE(e.getMessage());
        }
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> listTestApplicantInfo() {
        try {
            logger.info("inside list TestApplicantInfo");
            List<TestApplicantInfo> testApplicants = this.service.listTestApplicantInfo();

            return SUCCESS(testApplicants);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to list TestApplicantInfo", e);
            return FAILURE(e.getMessage());
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getTestApplicantInfo(@PathVariable("id") Long id) {
        try {
            logger.info("inside get TestApplicantInfo");
            TestApplicantInfo testApplicant = this.service.getTestApplicantInfo(id);

            return SUCCESS(testApplicant);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to get TestApplicant info", e);
            return FAILURE(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteTestApplicantInfo(@PathVariable("id") Long id) {
        try {
            logger.info("inside delete TestApplicantInfo");
            this.service.deleteTestApplicantInfo(id);
            // this.documentService.deleteDocumentByApplicantId(id);
            return SUCCESS("Job Applicant Info Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to delete TestApplicantInfo", e);
            return FAILURE(e.getMessage());
        }
    }

}
