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

import com.LT.Form.entity.TrainingCourse;
import com.LT.Form.entity.TraineeDocument;
import com.LT.Form.entity.TraineeInfo;
import com.LT.Form.service.TraineeInfoService;
import com.LT.Form.service.TrainingCourseService;
import com.LT.Form.util.GenericController;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Controller class to handle the TraineeInfo related operations
 * 
 * @author Dhruvil
 * @version 1.0
 */

@RestController
@RequestMapping("/form/trainee")
public class TraineeInfoController extends GenericController {

    private static Logger logger = LoggerFactory.getLogger(TraineeInfoController.class);

    @Autowired
    private TraineeInfoService traineeInfoService;

    @Autowired
    private TrainingCourseService trainingCourseService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> addTraineeInfo(@RequestPart("documents") MultipartFile[] documents,
            @RequestPart("data") String jsonData) {
        TraineeInfo traineeInfo = null;
        try {
            logger.info("Inside add TraineeInfo");

            ObjectMapper objectMapper = new ObjectMapper();
            traineeInfo = objectMapper.readValue(jsonData,
                    TraineeInfo.class);

            TrainingCourse course = trainingCourseService.getTrainingCourseById(traineeInfo.getTrainingCourseId());
            traineeInfo.setTrainingCourse(course);

            TraineeDocument traineeDocument = null;
            for (MultipartFile document : documents) {
                String fileName = StringUtils.cleanPath(document.getOriginalFilename());

                traineeDocument = new TraineeDocument();
                traineeDocument.setFileName(fileName);
                traineeDocument.setFileType(document.getContentType());
                traineeDocument.setData(document.getBytes());

                traineeInfo.addDocument(traineeDocument);
            }

            this.traineeInfoService.addTraineeInfo(traineeInfo);
            return SUCCESS(traineeInfo);
        } catch (Exception e) {
            e.printStackTrace();

            String msg = e.getMessage();
            logger.error("Unable to add", e);
            // if (msg != null && msg.contains("ConstraintViolationException"))
            // msg = traineeInfo.getPhoneNo() + " already present in the system";
            return FAILURE(msg);

        }
    }

    @PostMapping(path = "/update")
    public ResponseEntity<?> updateTraineeInfo(@RequestBody TraineeInfo traineeInfo) {
        try {
            logger.info("inside update traineeInfo");
            this.traineeInfoService.updateTraineeInfo(traineeInfo);
            return SUCCESS(traineeInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to update traineeInfo", e);
            return FAILURE(e.getMessage());
        }
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> listTraineeInfo() {
        try {
            logger.info("inside list TraineeInfo");
            List<TraineeInfo> trainees = this.traineeInfoService.listTraineeInfo();

            return SUCCESS(trainees);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to list TraineeInfo", e);
            return FAILURE(e.getMessage());
        }
    }

    @GetMapping(path = "/data/{id}")
    public ResponseEntity<?> getTraineeInfo(@PathVariable("id") Long id) {
        try {
            logger.info("inside get TraineeInfo");
            TraineeInfo trainee = this.traineeInfoService.getTraineeInfo(id);

            return SUCCESS(trainee);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to get Trainee info", e);
            return FAILURE(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteTraineeInfo(@PathVariable("id") Long id) {
        try {
            logger.info("inside delete TraineeInfo");
            this.traineeInfoService.deleteTraineeInfo(id);
            // this.documentService.deleteDocumentByTraineeId(id);
            return SUCCESS("Tainer Data Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to delete TraineeInfo", e);
            return FAILURE(e.getMessage());
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getTraineeInfoByEmail(@PathVariable("email") String email) {
        try {
            logger.info("inside get TraineeInfo by email");
            TraineeInfo traineeInfo = this.traineeInfoService.getTraineeInfo(email);
            return SUCCESS(traineeInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to get TraineeInfo", e);
            return FAILURE(e.getMessage());
        }
    }
}
