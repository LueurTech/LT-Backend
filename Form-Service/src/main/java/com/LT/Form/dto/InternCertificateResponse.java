package com.LT.Form.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 
 * @author Mukund
 * @version 1.0
 */
public class InternCertificateResponse {
	    private Long id;

	    private String name;

	    private String email;

	    private String phoneNo;

	    private String gender;

	    private Date dob;

	    private String city;

	    private String degree;

	    private String branch;

	    private String yop;

	    private String cgpa;

	    private String college_Name;

	    private String yop_12;

	    private String percentage_12;

	    private String college_12;

	    private String yop_10;

	    private String percentage_10;

	    private String school_10;

	    private int active_Backlog;

	    private String selectedDomain;

	    private String duration;

	    private LocalDateTime timestamp;
	    
	    private Date startDate;
	    
	    private Date endDate;
	    
	    private Date cetificateIssueDate;
	    
	    private String typeOfInternship;

		public InternCertificateResponse() {
			super();
			// TODO Auto-generated constructor stub
		}

		public InternCertificateResponse(Long id, String name, String email, String phoneNo, String gender, Date dob,
				String city, String degree, String branch, String yop, String cgpa, String college_Name, String yop_12,
				String percentage_12, String college_12, String yop_10, String percentage_10, String school_10,
				int active_Backlog, String selectedDomain, String duration, LocalDateTime timestamp, Date startDate,
				Date endDate, Date cetificateIssueDate, String typeOfInternship) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.phoneNo = phoneNo;
			this.gender = gender;
			this.dob = dob;
			this.city = city;
			this.degree = degree;
			this.branch = branch;
			this.yop = yop;
			this.cgpa = cgpa;
			this.college_Name = college_Name;
			this.yop_12 = yop_12;
			this.percentage_12 = percentage_12;
			this.college_12 = college_12;
			this.yop_10 = yop_10;
			this.percentage_10 = percentage_10;
			this.school_10 = school_10;
			this.active_Backlog = active_Backlog;
			this.selectedDomain = selectedDomain;
			this.duration = duration;
			this.timestamp = timestamp;
			this.startDate = startDate;
			this.endDate = endDate;
			this.cetificateIssueDate = cetificateIssueDate;
			this.typeOfInternship = typeOfInternship;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
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

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
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

		public String getCollege_Name() {
			return college_Name;
		}

		public void setCollege_Name(String college_Name) {
			this.college_Name = college_Name;
		}

		public String getYop_12() {
			return yop_12;
		}

		public void setYop_12(String yop_12) {
			this.yop_12 = yop_12;
		}

		public String getPercentage_12() {
			return percentage_12;
		}

		public void setPercentage_12(String percentage_12) {
			this.percentage_12 = percentage_12;
		}

		public String getCollege_12() {
			return college_12;
		}

		public void setCollege_12(String college_12) {
			this.college_12 = college_12;
		}

		public String getYop_10() {
			return yop_10;
		}

		public void setYop_10(String yop_10) {
			this.yop_10 = yop_10;
		}

		public String getPercentage_10() {
			return percentage_10;
		}

		public void setPercentage_10(String percentage_10) {
			this.percentage_10 = percentage_10;
		}

		public String getSchool_10() {
			return school_10;
		}

		public void setSchool_10(String school_10) {
			this.school_10 = school_10;
		}

		public int getActive_Backlog() {
			return active_Backlog;
		}

		public void setActive_Backlog(int active_Backlog) {
			this.active_Backlog = active_Backlog;
		}

		public String getSelectedDomain() {
			return selectedDomain;
		}

		public void setSelectedDomain(String selectedDomain) {
			this.selectedDomain = selectedDomain;
		}

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		public LocalDateTime getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public Date getCetificateIssueDate() {
			return cetificateIssueDate;
		}

		public void setCetificateIssueDate(Date cetificateIssueDate) {
			this.cetificateIssueDate = cetificateIssueDate;
		}

		public String getTypeOfInternship() {
			return typeOfInternship;
		}

		public void setTypeOfInternship(String typeOfInternship) {
			this.typeOfInternship = typeOfInternship;
		}
	    
	    

	    



}
