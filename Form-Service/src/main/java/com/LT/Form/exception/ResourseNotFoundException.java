package com.LT.Form.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Mukund
 * @version 1.0
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResourseNotFoundException { 
	
private static final long serialVersionUID = 1L;
	private String fieldName;
	private Object fieldValue;
	
	private String resourceName;
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	
}
