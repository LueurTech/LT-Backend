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

import com.LT.Form.entity.Domain;
import com.LT.Form.entity.InternDocument;
import com.LT.Form.entity.InternInfo;
import com.LT.Form.service.DomainService;
import com.LT.Form.service.InternInfoService;
import com.LT.Form.util.GenericController;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller class to handle the InternInfo related operations
 * 
 * @author Dhruvil
 * @version 1.0
 */

@RestController
@RequestMapping("/form/intern")
@Slf4j
public class InternInfoController extends GenericController {
    private static Logger logger = LoggerFactory.getLogger(InternInfoController.class);

    @Autowired
    private InternInfoService service;

    @Autowired
    private DomainService domainService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> addInternInfo(@RequestPart("documents") MultipartFile[] documents,
            @RequestPart("data") String jsonData) {
        InternInfo internInfo = null;
        try {
            logger.info("Inside add InternInfo");

            ObjectMapper objectMapper = new ObjectMapper();
            internInfo = objectMapper.readValue(jsonData,
                    InternInfo.class);

            Domain domain = domainService.getDomainById(internInfo.getDomainId());
            internInfo.setDomain(domain);

            InternDocument internDocument = null;
            for (MultipartFile document : documents) {
                String fileName = StringUtils.cleanPath(document.getOriginalFilename());

                internDocument = new InternDocument();
                internDocument.setFileName(fileName);
                internDocument.setFileType(document.getContentType());
                internDocument.setData(document.getBytes());

                internInfo.addDocument(internDocument);
            }

            this.service.addInternInfo(internInfo);
            return SUCCESS(internInfo);
        } catch (Exception e) {
            e.printStackTrace();

            String msg = e.getMessage();
            logger.error("Unable to add", e);
            // if (msg != null && msg.contains("ConstraintViolationException"))
            // msg = internInfo.getPhoneNo() + " already present in the system";
            return FAILURE(msg);

        }
    }

    @PostMapping(path = "/update")
    public ResponseEntity<?> updateInternInfo(@RequestBody InternInfo internInfo) {
        try {
            logger.info("inside update InternInfo");
            this.service.updateInternInfo(internInfo);
            return SUCCESS(internInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to update InternInfo", e);
            return FAILURE(e.getMessage());
        }
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> listInternInfo() {
        try {
            logger.info("inside list InternInfo");
            List<InternInfo> interns = this.service.listInternInfo();

            return SUCCESS(interns);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to list InternInfo", e);
            return FAILURE(e.getMessage());
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getInternInfo(@PathVariable("id") Long id) {
        try {
            logger.info("inside get InternInfo");
            InternInfo intern = this.service.getInternInfo(id);

            return SUCCESS(intern);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to get Intern info", e);
            return FAILURE(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteInternInfo(@PathVariable("id") Long id) {
        try {
            logger.info("inside delete InternInfo");
            this.service.deleteInternInfo(id);
            // this.documentService.deleteDocumentByInternId(id);
            return SUCCESS("Job Applicant Info Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to delete InternInfo", e);
            return FAILURE(e.getMessage());
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getInternInfoByEmail(@PathVariable("email") String email) {
        try {
            logger.info("inside get InternInfo by email");
            InternInfo internInfo = this.service.getInternInfo(email);
            return SUCCESS(internInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to get InternInfo", e);
            return FAILURE(e.getMessage());
        }
    }

}
