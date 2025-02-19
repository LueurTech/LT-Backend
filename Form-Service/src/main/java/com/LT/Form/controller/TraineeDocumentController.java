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

import com.LT.Form.entity.TraineeDocument;
import com.LT.Form.service.TraineeDocumentService;
import com.LT.Form.util.GenericController;

@RestController
@RequestMapping("/form/trainee")
public class TraineeDocumentController extends GenericController {

    private static Logger logger = LoggerFactory.getLogger(TraineeDocumentController.class);

    @Autowired
    private TraineeDocumentService traineeDocumentService;

    @GetMapping("/document/{traineeId}")
    public ResponseEntity<?> listTraineeDocumentsByTraineeId(@PathVariable Long traineeId) throws Exception {
        try {
            logger.info("inside get TraineeInfo");

            List<TraineeDocument> traineeDocuments = this.traineeDocumentService
                    .getTraineeDocumentsByTraineeId(traineeId);
            return SUCCESS(traineeDocuments);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to get Trainee info", e);
            return FAILURE(e.getMessage());
        }

    }
}
