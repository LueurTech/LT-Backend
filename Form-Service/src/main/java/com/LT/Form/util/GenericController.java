package com.LT.Form.util;

import org.springframework.http.ResponseEntity;

/**
 * Response model common object
 * 
 * @author Mukund
 * @version 1.0
 */
public class GenericController {
	protected static final ResponseEntity<?> SUCCESS(Object resObject){
		return SUCCESS(null,resObject);
	}

	protected static final ResponseEntity<?> SUCCESSMESG(Object respObject) {
		return SUCCESSMESG(null, respObject);
	}
	
	protected static final ResponseEntity<?> SUCCESSMESG(String msg, Object respObject) {
		return ResponseEntity.ok(new RespModel(respObject));
	}
	
	protected static final ResponseEntity<?> SUCCESS(String msg, Object respObject) {
		return ResponseEntity.ok(new ResponseModel(200, msg == null ? "success" : msg, respObject));
	}

	protected static final ResponseEntity<?> WARNING(Object respObject) {
		return WARNING(null, respObject);
	}

	protected static final ResponseEntity<?> WARNING(String msg, Object respObject) {
		return ResponseEntity.ok(new ResponseModel(208, msg == null ? "warning" : msg, respObject));
	}

	protected static final ResponseEntity<?> FAILURE(Object respObject) {
		return FAILURE(null, respObject);
	}

	protected static final ResponseEntity<?> FAILURE(String msg, Object respObject) {
		return ResponseEntity.ok(new ResponseModel(209, msg == null ? "failure" : msg, respObject));
	}

	protected static final ResponseEntity<?> failureInvalid(Object error) {
		return ResponseEntity.ok(new RespModel(error));
	}

	protected static final ResponseEntity<?> failureexists(Object error) {
		return ResponseEntity.ok(new RespModel(error));
	}

	protected static final ResponseEntity<?> openTripsFailure(Object error) {
		return ResponseEntity.ok(new RespModel(error));
	}

	protected static final ResponseEntity<?> failureAuth(Object error) {
		return ResponseEntity.ok(new RespModel(error));
	}
	
	protected static final ResponseEntity<?> FAILURE1(String msg, Object respObject) {
		return ResponseEntity.ok(new ResponseModel(401, msg == null ? "UNAUTHORIZED" : msg, respObject));
	}
	
	protected static final ResponseEntity<?> AUTHENTICATIONFAILURE(String msg, Object respObject) {
		return ResponseEntity.ok(new ResponseModel(401, msg == null ? "UNAUTHORIZED" : msg, respObject));
	}
	
	protected static final ResponseEntity<?> SUCCESSGENRIC(String msg, Object respObject) {
		return ResponseEntity.ok(new ResponseModel(200, msg == null ? "success" : msg, respObject));
	}
	
	protected static final ResponseEntity<?> FAILUREGENERIC(String msg, Object respObject) {
		return ResponseEntity.ok(new ResponseModel(209, msg == null ? "failure" : msg, respObject));
	}

}
