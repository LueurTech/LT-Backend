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

import com.LT.Form.entity.TrainingCourse;
import com.LT.Form.service.TrainingCourseService;
import com.LT.Form.util.GenericController;

@RequestMapping("/trainingCourse")
@RestController
public class TrainingCourseController extends GenericController {

    private static Logger logger = LoggerFactory.getLogger(TrainingCourseController.class);

    @Autowired
    private TrainingCourseService trainingCourseService;

    @GetMapping("/list")
    public ResponseEntity<?> listTrainingCourses() {
        try {
            logger.info("inside list ListTrainingCourses");
            List<TrainingCourse> trainingCourses = trainingCourseService.getAllTrainingCourses();
            return SUCCESS(trainingCourses);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to list TrainingCourses", e);
            return FAILURE(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTrainingCourse(@RequestBody TrainingCourse trainingCourse) {
        try {
            logger.info("inside list AddTrainingCourse");
            return SUCCESS(trainingCourseService.addTrainingCourse(trainingCourse));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to add TrainingCourse", e);
            return FAILURE(e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateTrainingCourse(@RequestBody TrainingCourse trainingCourse) {
        try {
            logger.info("inside list AddTrainingCourse");
            return SUCCESS(trainingCourseService.updateTrainingCourse(trainingCourse));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to add TrainingCourse", e);
            return FAILURE(e.getMessage());
        }
    }
}
