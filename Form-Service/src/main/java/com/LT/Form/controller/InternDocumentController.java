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

import com.LT.Form.entity.InternDocument;
import com.LT.Form.service.InternDocumentService;
import com.LT.Form.util.GenericController;

@RestController
@RequestMapping("/form/intern")
public class InternDocumentController extends GenericController {

    private static Logger logger = LoggerFactory.getLogger(InternDocumentController.class);

    @Autowired
    private InternDocumentService internDocumentService;

    @GetMapping("/document/{internId}")
    public ResponseEntity<?> listInternDocumentsByInternId(@PathVariable Long internId) throws Exception {
        try {
            logger.info("inside get InternInfo");

            List<InternDocument> internDocuments = this.internDocumentService.getInternDocumentsByInternId(internId);
            return SUCCESS(internDocuments);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to get Intern info", e);
            return FAILURE(e.getMessage());
        }

    }
}
