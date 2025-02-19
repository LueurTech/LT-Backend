package com.LT.QnA.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LT.QnA.entity.JobQuestion;
import com.LT.QnA.service.JobQuestionService;
import com.LT.QnA.util.GenericController;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller class to handle the JobQuestion related operations
 * 
 * @author Dhruvil
 * @version 1.0
 */
@RestController
@RequestMapping("/jobQuestion")
@Slf4j
public class JobQuestionController extends GenericController {

    private static Logger logger = LoggerFactory.getLogger(JobQuestionController.class);

    @Autowired
    private JobQuestionService jobQuestionService;

    @PostMapping("/add")
    public ResponseEntity<?> addJobQuestion(@RequestBody JobQuestion jobQuestion) {
        try {
            logger.info("Inside add JobQuestion");
            this.jobQuestionService.addJobQuestion(jobQuestion);
            return SUCCESS(jobQuestion);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = e.getMessage();
            logger.error("Unable to add", e);
            if (msg != null && msg.contains("ConstraintViolationException"))
                msg = jobQuestion.getId() + " already present in the system";
            return FAILURE(msg);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateJobQuestion(@RequestBody JobQuestion jobQuestion) {
        try {
            logger.info("Inside update JobQuestion");
            this.jobQuestionService.updatJobQuestion(jobQuestion);
            return SUCCESS(jobQuestion);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = e.getMessage();
            logger.error("Unable to update", e);

            return FAILURE(msg);
        }
    }

    @GetMapping("/{type}")
    public ResponseEntity<?> getJobQuestionsByQuestionType(@PathVariable("type") String questionType) {
        try {
            logger.info("inside get JobQuestion By Type");
            List<JobQuestion> jobQuestions = this.jobQuestionService.getJobQuestionsByType(questionType);
            return SUCCESS(jobQuestions);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to get JobQuestion", e);
            return FAILURE(e.getMessage());
        }
    }

    @GetMapping("/technical/{programmingLanguage}")
    public ResponseEntity<?> getJobQuestionByProgrammingLanguage(
            @PathVariable("programmingLanguage") String programmingLanguage) {
        try {
            logger.info("inside get JobQuestion By Programming Language");
            List<JobQuestion> jobQuestions = this.jobQuestionService
                    .getJobQuestionByProgrammingLanguage(programmingLanguage);
            return SUCCESS(jobQuestions);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to get JobQuestion", e);
            return FAILURE(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteJobQuestion(@PathVariable("id") Long id) {
        try {
            logger.info("inside delete JobQuestion");
            this.jobQuestionService.deleteJobQuestion(id);
            return SUCCESS("JobQuestion Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("unable to delete JobQuestion", e);
            return FAILURE(e.getMessage());
        }
    }
}
