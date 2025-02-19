package com.LT.Form.util;

/**
 * Class the send the response in the standard format
 * 
 * @author Mukund
 * @version 1.0
 *
 */
public class ResponseModel {
	
	private int code;
	private String message;
	private Object responseBody;
	
	public ResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseModel(int code, String message, Object responseBody) {
		super();
		this.code = code;
		this.message = message;
		this.responseBody = responseBody;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(Object responseBody) {
		this.responseBody = responseBody;
	}


}
