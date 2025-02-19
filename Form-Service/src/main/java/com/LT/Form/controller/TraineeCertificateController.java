package com.LT.Form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LT.Form.entity.TrainingCourse;
import com.LT.Form.entity.TraineeCertificateDetails;
import com.LT.Form.service.TrainingCourseService;
import com.LT.Form.service.TraineeCertificateService;
import com.LT.Form.util.GenericController;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Controller class to handle the Trainee Certificate related operations
 * 
 * @author Mukund
 * @version 1.0
 */

@RestController
@RequestMapping("/form/TraineeCertificate")
@Slf4j
public class TraineeCertificateController extends GenericController {

    @Autowired
    private TraineeCertificateService certificateService;

    @Autowired
    private TrainingCourseService trainingCourseService;

    private static final Logger logger = LoggerFactory.getLogger(TraineeCertificateController.class);
    //
    // @PostMapping(value = "/add")
    // public ResponseEntity<?> addTraineecertificateDetails(@RequestBody
    // TraineeCertificateDetails traineeCertificateDetails) {
    // try {
    // logger.info("Inside add TraineeCertificateDetails");
    //
    //
    // this.certificateService.addTraineecertificateDetails(traineeCertificateDetails);
    // return SUCCESS(traineeCertificateDetails);
    // } catch (Exception e) {
    // e.printStackTrace();
    //
    // String msg = e.getMessage();
    // logger.error("Unable to add", e);
    // if (msg != null && msg.contains("ConstraintViolationException"))
    // msg = traineeCertificateDetails.getPhoneNo() + " already present in the
    // system";
    // return FAILURE(msg);
    //
    // }
    // }
    //

    @PostMapping(value = "/add")
    public ResponseEntity<?> addTraineecertificateDetails(
            @RequestBody TraineeCertificateDetails traineeCertificateDetails) {
        try {
            logger.info("Inside add TraineeCertificateDetails");

            TrainingCourse trainingCourse = trainingCourseService
                    .getTrainingCourseById(traineeCertificateDetails.getTrainingCourseId());
            traineeCertificateDetails.setTrainingCourse(trainingCourse);

            this.certificateService.addTraineecertificateDetails(traineeCertificateDetails);
            return SUCCESS(traineeCertificateDetails);
        } catch (Exception e) {
            e.printStackTrace();

            String msg = e.getMessage();
            logger.error("Unable to add", e);

            // Handle the specific exception where email or phone already exists
            if (msg != null && (msg.contains("Email") || msg.contains("Phone number"))) {
                return FAILURE(msg);
            }

            // For other exceptions
            return FAILURE("An error occurred while processing the request.");
        }
    }

    @PostMapping(path = "/update")
    public ResponseEntity<?> updateTraineecertificateDetails(
            @RequestBody TraineeCertificateDetails traineeCertificateDetails) {
        try {
            logger.info("inside update TraineeInfo");
            this.certificateService.addTraineecertificateDetails(traineeCertificateDetails);
            return SUCCESS(traineeCertificateDetails);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to update TraineeInfo", e);
            return FAILURE(e.getMessage());
        }
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> listTraineeCertificateDetails() {
        try {
            logger.info("inside list TraineeInfo");
            List<TraineeCertificateDetails> traineesCertificate = this.certificateService
                    .listTraineeCertificateDetails();

            return SUCCESS(traineesCertificate);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to list TraineeInfo", e);
            return FAILURE(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteTraineeCertificateDetails(@PathVariable("id") Long id) {
        try {
            logger.info("inside delete TraineeInfo");
            this.certificateService.deleteTraineeCertificateDetails(id);
            return SUCCESS("Job Applicant Info Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to delete TraineeInfo", e);
            return FAILURE(e.getMessage());
        }
    }

}
