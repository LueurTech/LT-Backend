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

import com.LT.Form.entity.Domain;
import com.LT.Form.entity.InternCertificateDetails;
import com.LT.Form.service.DomainService;
import com.LT.Form.service.InternCertificateService;
import com.LT.Form.util.GenericController;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Controller class to handle the Intern Certificate related operations
 * 
 * @author Mukund
 * @version 1.0
 */

@RestController
@RequestMapping("/form/InternCertificate")
@Slf4j
public class InternCertificateController extends GenericController {

	@Autowired
	private InternCertificateService certificateService;

	@Autowired
	private DomainService domainService;

	private static final Logger logger = LoggerFactory.getLogger(InternCertificateController.class);
	//
	// @PostMapping(value = "/add")
	// public ResponseEntity<?> addInterncertificateDetails(@RequestBody
	// InternCertificateDetails internCertificateDetails) {
	// try {
	// logger.info("Inside add InternCertificateDetails");
	//
	//
	// this.certificateService.addInterncertificateDetails(internCertificateDetails);
	// return SUCCESS(internCertificateDetails);
	// } catch (Exception e) {
	// e.printStackTrace();
	//
	// String msg = e.getMessage();
	// logger.error("Unable to add", e);
	// if (msg != null && msg.contains("ConstraintViolationException"))
	// msg = internCertificateDetails.getPhoneNo() + " already present in the
	// system";
	// return FAILURE(msg);
	//
	// }
	// }
	//

	@PostMapping(value = "/add")
	public ResponseEntity<?> addInterncertificateDetails(
			@RequestBody InternCertificateDetails internCertificateDetails) {
		try {
			logger.info("Inside add InternCertificateDetails");

			Domain domain = domainService.getDomainById(internCertificateDetails.getDomainId());
			internCertificateDetails.setDomain(domain);

			this.certificateService.addInterncertificateDetails(internCertificateDetails);
			return SUCCESS(internCertificateDetails);
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
	public ResponseEntity<?> updateInterncertificateDetails(
			@RequestBody InternCertificateDetails internCertificateDetails) {
		try {
			logger.info("inside update InternInfo");
			this.certificateService.addInterncertificateDetails(internCertificateDetails);
			return SUCCESS(internCertificateDetails);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("unable to update InternInfo", e);
			return FAILURE(e.getMessage());
		}
	}

	@GetMapping(path = "/list")
	public ResponseEntity<?> listInternCertificateDetails() {
		try {
			logger.info("inside list InternInfo");
			List<InternCertificateDetails> internsCertificate = this.certificateService.listInternCertificateDetails();

			return SUCCESS(internsCertificate);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("unable to list InternInfo", e);
			return FAILURE(e.getMessage());
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteInternCertificateDetails(@PathVariable("id") Long id) {
		try {
			logger.info("inside delete InternInfo");
			this.certificateService.deleteInternCertificateDetails(id);
			return SUCCESS("Job Applicant Info Deleted");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("unable to delete InternInfo", e);
			return FAILURE(e.getMessage());
		}
	}

}
