package com.LT.Form.dto;

import java.sql.Timestamp;
import java.util.Date;
/**
 * 
 * @author Mukund
 * @version 1.0
 */
public class TraineeInfoResponse {
	 private long id;

	    private String name;

	    private String email;

	    private String phoneNo;
	    
	    private String gender;

	    private Date dob;
	    
	    private String address;
	    
	    private String state;
	    
	    private String landmark;
	    
	    private String city;

	    private String pinCode;
	    
	    private String degree;

	    private String branch;

	    private String yop;

	    private String cgpa;

	    private String collegeName;
	  
	    private String skills;

	    private String duration;  
	  
	    private Timestamp timestamp;

		public TraineeInfoResponse() {
			super();
			// TODO Auto-generated constructor stub
		}

		public TraineeInfoResponse(long id, String name, String email, String phoneNo, String gender, Date dob,
				String address, String state, String landmark, String city, String currentPinCode, String degree,
				String branch, String yop, String cgpa, String collegeName, String skills, String duration,
				Timestamp timestamp) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.phoneNo = phoneNo;
			this.gender = gender;
			this.dob = dob;
			this.address = address;
			this.state = state;
			this.landmark = landmark;
			this.city = city;
			this.pinCode = currentPinCode;
			this.degree = degree;
			this.branch = branch;
			this.yop = yop;
			this.cgpa = cgpa;
			this.collegeName = collegeName;
			this.skills = skills;
			this.duration = duration;
			this.timestamp = timestamp;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getLandmark() {
			return landmark;
		}

		public void setLandmark(String landmark) {
			this.landmark = landmark;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCurrentPinCode() {
			return pinCode;
		}

		public void setCurrentPinCode(String currentPinCode) {
			this.pinCode = currentPinCode;
		}

		public String getDegree() {
			return degree;
		}

		public void setDegree(String degree) {
			this.degree = degree;
		}

		public String getBranch() {
			return branch;
		}

		public void setBranch(String branch) {
			this.branch = branch;
		}

		public String getYop() {
			return yop;
		}

		public void setYop(String yop) {
			this.yop = yop;
		}

		public String getCgpa() {
			return cgpa;
		}

		public void setCgpa(String cgpa) {
			this.cgpa = cgpa;
		}

		public String getCollegeName() {
			return collegeName;
		}

		public void setCollegeName(String collegeName) {
			this.collegeName = collegeName;
		}

		public String getSkills() {
			return skills;
		}

		public void setSkills(String skills) {
			this.skills = skills;
		}

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		public Timestamp getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Timestamp timestamp) {
			this.timestamp = timestamp;
		}
	    
	    
	

}
