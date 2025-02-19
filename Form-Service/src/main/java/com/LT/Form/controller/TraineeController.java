package com.LT.Form.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LT.Form.entity.TraineeInfo;
import com.LT.Form.service.TraineeInfoService;
import com.LT.Form.util.GenericController;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/form/Trainee")
@Slf4j
public class TraineeController extends GenericController {
	
	private static Logger logger = LoggerFactory.getLogger(InternInfoController.class);
	
	
	@Autowired
	private TraineeInfoService traineeInfoService;
	
	@PostMapping(value = "/add")
  public ResponseEntity<?> addTraineeInfo(@RequestBody TraineeInfo traineeInfo) {
      try {
          logger.info("Inside add TraineeDetails");
      	
      
           this.traineeInfoService.addTraineeInfo(traineeInfo);
          return SUCCESS(traineeInfo);
      } catch (Exception e) {
          e.printStackTrace();

          String msg = e.getMessage();
          logger.error("Unable to add", e);
           if (msg != null && msg.contains("ConstraintViolationException"))
           msg = traineeInfo.getPhoneNo() + " already present in the system";
          return FAILURE(msg);

      }
  }
	
	


}
