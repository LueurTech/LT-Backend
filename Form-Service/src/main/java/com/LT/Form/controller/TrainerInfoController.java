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

import com.LT.Form.entity.JobRole;
import com.LT.Form.entity.TrainerDocument;
import com.LT.Form.entity.TrainerInfo;
import com.LT.Form.service.JobRoleService;
import com.LT.Form.service.TrainerInfoService;
import com.LT.Form.util.GenericController;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller class to handle the TrainerInfo related operations
 * 
 * @author Mukund
 * @version 1.0
 */

@RestController
@RequestMapping("/form/trainer")
public class TrainerInfoController extends GenericController {

	private static Logger logger = LoggerFactory.getLogger(TrainerInfoController.class);

	@Autowired
	private TrainerInfoService trainerInfoService;

	@Autowired
	private JobRoleService jobRoleService;

	@PostMapping(value = "/add")
	public ResponseEntity<?> addTrainerInfo(@RequestPart("documents") MultipartFile[] documents,
			@RequestPart("data") String jsonData) {
		TrainerInfo trainerInfo = null;
		try {
			logger.info("Inside add TrainerInfo");

			ObjectMapper objectMapper = new ObjectMapper();
			trainerInfo = objectMapper.readValue(jsonData,
					TrainerInfo.class);

			JobRole jobRole = jobRoleService.getJobRoleById(trainerInfo.getJobRoleId());
			trainerInfo.setJobRole(jobRole);

			TrainerDocument trainerDocument = null;
			for (MultipartFile document : documents) {
				String fileName = StringUtils.cleanPath(document.getOriginalFilename());

				trainerDocument = new TrainerDocument();
				trainerDocument.setFileName(fileName);
				trainerDocument.setFileType(document.getContentType());
				trainerDocument.setData(document.getBytes());

				trainerInfo.addDocument(trainerDocument);
			}

			this.trainerInfoService.addTrainerInfo(trainerInfo);
			return SUCCESS(trainerInfo);
		} catch (Exception e) {
			e.printStackTrace();

			String msg = e.getMessage();
			logger.error("Unable to add", e);
			return FAILURE(msg);

		}
	}

	@PostMapping(path = "/update")
	public ResponseEntity<?> updateTrainerInfo(@RequestBody TrainerInfo trainerInfo) {
		try {
			logger.info("inside update trainerInfo");
			this.trainerInfoService.updateTrainerInfo(trainerInfo);
			return SUCCESS(trainerInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("unable to update trainerInfo", e);
			return FAILURE(e.getMessage());
		}
	}

	@GetMapping(path = "/list")
	public ResponseEntity<?> listTrainerInfo() {
		try {
			logger.info("inside list TrainerInfo");
			List<TrainerInfo> trainers = this.trainerInfoService.listTrainerInfo();

			return SUCCESS(trainers);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("unable to list TrainerInfo", e);
			return FAILURE(e.getMessage());
		}
	}

	@GetMapping(path = "/data/{id}")
	public ResponseEntity<?> getTrainerInfo(@PathVariable("id") Long id) {
		try {
			logger.info("inside get TrainerInfo");
			TrainerInfo trainer = this.trainerInfoService.getTrainerInfo(id);

			return SUCCESS(trainer);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("unable to get Intern info", e);
			return FAILURE(e.getMessage());
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteTrainerInfo(@PathVariable("id") Long id) {
		try {
			logger.info("inside delete TrainerInfo");
			this.trainerInfoService.deleteTrainerInfo(id);
			// this.documentService.deleteDocumentByInternId(id);
			return SUCCESS("Tainer Data Deleted");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("unable to delete TrainerInfo", e);
			return FAILURE(e.getMessage());
		}
	}

}
