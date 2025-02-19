package com.LT.Form.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LT.Form.entity.Domain;
import com.LT.Form.service.DomainService;
import com.LT.Form.util.GenericController;

@RequestMapping("/domain")
@RestController
public class DomainController extends GenericController {

    private static Logger logger = LoggerFactory.getLogger(DomainController.class);

    @Autowired
    private DomainService domainService;

    @GetMapping("/list")
    public ResponseEntity<?> listDomains() {
        try {
            logger.info("inside list ListDomains");
            List<Domain> domains = domainService.getAllDomains();
            return SUCCESS(domains);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to list Domains", e);
            return FAILURE(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addDomain(@RequestBody Domain domain) {
        try {
            logger.info("inside list AddDomain");
            return SUCCESS(domainService.addDomain(domain));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to add Domain", e);
            return FAILURE(e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateDomain(@RequestBody Domain domain) {
        try {
            logger.info("inside list AddDomain");
            return SUCCESS(domainService.updateDomain(domain));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to add Domain", e);
            return FAILURE(e.getMessage());
        }
    }
}
