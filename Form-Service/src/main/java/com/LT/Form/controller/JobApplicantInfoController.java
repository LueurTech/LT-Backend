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

import com.LT.Form.entity.JobApplicantDocument;
import com.LT.Form.entity.JobApplicantInfo;
import com.LT.Form.entity.JobRole;
import com.LT.Form.service.JobApplicantInfoService;
import com.LT.Form.service.JobRoleService;
import com.LT.Form.util.GenericController;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller class to handle the JobApplicantInfo related operations
 * 
 * @author Mukund
 * @version 1.0
 */

@RestController
@RequestMapping("/form/jobApplicant")
@Slf4j
public class JobApplicantInfoController extends GenericController {
	private static Logger logger = LoggerFactory.getLogger(JobApplicantInfoController.class);

	@Autowired
	private JobApplicantInfoService service;

	@Autowired
	private JobRoleService jobRoleService;

	@PostMapping(value = "/add")
	public ResponseEntity<?> addJobApplicantInfo(@RequestPart("documents") MultipartFile[] documents,
			@RequestPart("data") String jsonData) {
		JobApplicantInfo jobApplicantInfo = null;
		try {
			logger.info("Inside add JobApplicantInfo");

			ObjectMapper objectMapper = new ObjectMapper();
			jobApplicantInfo = objectMapper.readValue(jsonData,
					JobApplicantInfo.class);

			JobRole jobRole = jobRoleService.getJobRoleById(jobApplicantInfo.getJobRoleId());
			jobApplicantInfo.setJobRole(jobRole);

			JobApplicantDocument jobApplicantDocument = null;
			for (MultipartFile document : documents) {
				String fileName = StringUtils.cleanPath(document.getOriginalFilename());

				jobApplicantDocument = new JobApplicantDocument();
				jobApplicantDocument.setFileName(fileName);
				jobApplicantDocument.setFileType(document.getContentType());
				jobApplicantDocument.setData(document.getBytes());

				jobApplicantInfo.addDocument(jobApplicantDocument);
			}

			this.service.addJobApplicantInfo(jobApplicantInfo);
			return SUCCESS(jobApplicantInfo);
		} catch (Exception e) {
			e.printStackTrace();

			String msg = e.getMessage();
			logger.error("Unable to add", e);
			// if (msg != null && msg.contains("ConstraintViolationException"))
			// msg = jobApplicantInfo.getPhoneNo() + " already present in the system";
			return FAILURE(msg);

		}
	}

	// @PostMapping(path = "/updateMarks")
	// public ResponseEntity<?> updateJobApplicantMarks(@RequestBody
	// JobApplicantMarksRequest marksRequest) {
	// try {
	// logger.info("inside update JobApplicantMarks");
	// JobApplicantInfo jobApplicantInfo =
	// this.service.updateJobApplicantMarks(marksRequest);
	// return SUCCESS(jobApplicantInfo);
	// } catch (Exception e) {
	// e.printStackTrace();
	// logger.error("unable to update JobApplicant Marks", e);
	// return FAILURE(e.getMessage());
	// }
	// }

	@PostMapping(path = "/update")
	public ResponseEntity<?> updateJobApplicantInfo(@RequestBody JobApplicantInfo jobApplicantInfo) {
		try {
			logger.info("inside update JobApplicantInfo");
			this.service.updateJobApplicantInfo(jobApplicantInfo);
			return SUCCESS(jobApplicantInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("unable to update JobApplicantInfo", e);
			return FAILURE(e.getMessage());
		}
	}

	@GetMapping(path = "/list")
	public ResponseEntity<?> listJobApplicantInfo() {
		try {
			logger.info("inside list JobApplicantInfo");
			List<JobApplicantInfo> jobApplicants = this.service.listJobApplicantInfo();

			return SUCCESS(jobApplicants);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("unable to list JobApplicantInfo", e);
			return FAILURE(e.getMessage());
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getJobApplicantInfo(@PathVariable("id") Long id) {
		try {
			logger.info("inside get JobApplicantInfo");
			JobApplicantInfo jobApplicant = this.service.getJobApplicantInfo(id);

			return SUCCESS(jobApplicant);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("unable to get JobApplicant info", e);
			return FAILURE(e.getMessage());
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteJobApplicantInfo(@PathVariable("id") Long id) {
		try {
			logger.info("inside delete JobApplicantInfo");
			this.service.deleteJobApplicantInfo(id);
			// this.documentService.deleteDocumentByApplicantId(id);
			return SUCCESS("Job Applicant Info Deleted");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("unable to delete JobApplicantInfo", e);
			return FAILURE(e.getMessage());
		}
	}

}
