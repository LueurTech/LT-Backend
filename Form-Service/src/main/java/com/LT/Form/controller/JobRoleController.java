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

import com.LT.Form.entity.JobRole;
import com.LT.Form.service.JobRoleService;
import com.LT.Form.util.GenericController;

@RequestMapping("/jobRole")
@RestController
public class JobRoleController extends GenericController {

    private static Logger logger = LoggerFactory.getLogger(JobRoleController.class);

    @Autowired
    private JobRoleService jobRoleService;

    @GetMapping("/list")
    public ResponseEntity<?> listJobRoles() {
        try {
            logger.info("inside list ListJobRoles");
            List<JobRole> jobRoles = jobRoleService.getAllJobRoles();
            return SUCCESS(jobRoles);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to list JobRoles", e);
            return FAILURE(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addJobRole(@RequestBody JobRole jobRole) {
        try {
            logger.info("inside list AddJobRole");
            return SUCCESS(jobRoleService.addJobRole(jobRole));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to add JobRole", e);
            return FAILURE(e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateJobRole(@RequestBody JobRole jobRole) {
        try {
            logger.info("inside list AddJobRole");
            return SUCCESS(jobRoleService.updateJobRole(jobRole));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to add JobRole", e);
            return FAILURE(e.getMessage());
        }
    }
}
