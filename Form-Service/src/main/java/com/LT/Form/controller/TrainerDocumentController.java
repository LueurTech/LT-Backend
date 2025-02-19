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
import com.LT.Form.entity.TrainerDocument;
import com.LT.Form.service.TrainerDocumentService;
import com.LT.Form.util.GenericController;

/**
 * Controller class to handle the Trainer Documents related operations
 * 
 * @author Mukund
 * @version 1.0
 */

@RestController
@RequestMapping("/form/trainer")
public class TrainerDocumentController extends GenericController {

	private static Logger logger = LoggerFactory.getLogger(TrainerDocumentController.class);

	@Autowired
	private TrainerDocumentService trainerDocumentService;

	@GetMapping("/document/{trainerId}")
	public ResponseEntity<?> listInternDocumentsByInternId(@PathVariable Long trainerId) throws Exception {
		try {
			logger.info("inside get InternInfo");

			List<TrainerDocument> internDocuments = this.trainerDocumentService
					.getTrainerDocumentsByTrainerId(trainerId);
			return SUCCESS(internDocuments);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("unable to get Intern info", e);
			return FAILURE(e.getMessage());
		}

	}

}
