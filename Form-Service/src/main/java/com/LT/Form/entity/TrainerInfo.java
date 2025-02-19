package com.LT.Form.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

/**
 * Entity class to maintain the Trainer Details information
 * 
 * @author Mukund
 * @version 1.0
 *
 */
@Entity
@Table(name = "TrainerDetails")
public class TrainerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "job_role_id")
	private JobRole jobRole;

	@Transient
	private Long jobRoleId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "phoneNo", nullable = false)
	private String phoneNo;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Temporal(TemporalType.DATE)
	@Column(name = "dob", nullable = true)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dob;

	@Column(name = "current_address", nullable = false)
	private String currentAddress;

	@Column(name = "current_state", nullable = false)
	private String currentState;

	@Column(name = "current_landmark", nullable = false)
	private String currentLandmark;

	@Column(name = "current_city", nullable = false)
	private String currentCity;

	@Column(name = "current_pinCode", nullable = false)
	private String currentPinCode;

	@Column(name = "permanent_address", nullable = false)
	private String permanentAddress;

	@Column(name = "permanent_state", nullable = false)
	private String permanentState;

	@Column(name = "permanent_landmark", nullable = false)
	private String permanentLandmark;

	@Column(name = "permanent_city", nullable = false)
	private String permanentCity;

	@Column(name = "permanent_pinCode", nullable = false)
	private String permanentPinCode;

	@Column(name = "degree", nullable = false)
	private String degree;

	@Column(name = "branch", nullable = false)
	private String branch;

	@Column(name = "yop", nullable = false)
	private String yop;

	@Column(name = "cgpa", nullable = false)
	private String cgpa;

	@Column(name = "college_Name", nullable = false)
	private String collegeName;

	@Column(name = "skills", nullable = false)
	private String skills;

	@Column(name = "yearsOfExperience", nullable = false)
	private String yearsOfExperience;

	@Column(name = "dateOfAvailability", nullable = false)
	private String dateOfAvailability;

	@Column(name = "timestamp")
	private Timestamp timestamp;

	@JsonIgnore
	@OneToMany(mappedBy = "trainerInfo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TrainerDocument> documents = new ArrayList<>();

	public TrainerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainerInfo(long id, String name, String email, String phoneNo, String gender, Date dob,
			String currentAddress, String currentState, String currentLandmark, String currentCity,
			String currentPinCode, String permanentAddress, String permanentState, String permanentLandmark,
			String permanentCity, String permanentPinCode, String degree, String branch, String yop, String cgpa,
			String college_Name, String skills, String yearsOfExperience, String dateOfAvailability,
			Timestamp timestamp) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.dob = dob;
		this.currentAddress = currentAddress;
		this.currentState = currentState;
		this.currentLandmark = currentLandmark;
		this.currentCity = currentCity;
		this.currentPinCode = currentPinCode;
		this.permanentAddress = permanentAddress;
		this.permanentState = permanentState;
		this.permanentLandmark = permanentLandmark;
		this.permanentCity = permanentCity;
		this.permanentPinCode = permanentPinCode;
		this.degree = degree;
		this.branch = branch;
		this.yop = yop;
		this.cgpa = cgpa;
		this.collegeName = college_Name;
		this.skills = skills;
		this.yearsOfExperience = yearsOfExperience;
		this.dateOfAvailability = dateOfAvailability;
		this.timestamp = timestamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public JobRole getJobRole() {
		return jobRole;
	}

	public void setJobRole(JobRole jobRole) {
		this.jobRole = jobRole;
	}

	public Long getJobRoleId() {
		return jobRoleId;
	}

	public void setJobRoleId(Long jobRoleId) {
		this.jobRoleId = jobRoleId;
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

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public String getCurrentLandmark() {
		return currentLandmark;
	}

	public void setCurrentLandmark(String currentLandmark) {
		this.currentLandmark = currentLandmark;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getCurrentPinCode() {
		return currentPinCode;
	}

	public void setCurrentPinCode(String currentPinCode) {
		this.currentPinCode = currentPinCode;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPermanentState() {
		return permanentState;
	}

	public void setPermanentState(String permanentState) {
		this.permanentState = permanentState;
	}

	public String getPermanentLandmark() {
		return permanentLandmark;
	}

	public void setPermanentLandmark(String permanentLandmark) {
		this.permanentLandmark = permanentLandmark;
	}

	public String getPermanentCity() {
		return permanentCity;
	}

	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}

	public String getPermanentPinCode() {
		return permanentPinCode;
	}

	public void setPermanentPinCode(String permanentPinCode) {
		this.permanentPinCode = permanentPinCode;
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

	public void setCollegeName(String college_Name) {
		this.collegeName = college_Name;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getDateOfAvailability() {
		return dateOfAvailability;
	}

	public void setDateOfAvailability(String dateOfAvailability) {
		this.dateOfAvailability = dateOfAvailability;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "TrainerInfo [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", gender="
				+ gender + ", dob=" + dob + ", currentAddress=" + currentAddress + ", currentState=" + currentState
				+ ", currentLandmark=" + currentLandmark + ", currentCity=" + currentCity + ", currentPinCode="
				+ currentPinCode + ", permanentAddress=" + permanentAddress + ", permanentState=" + permanentState
				+ ", permanentLandmark=" + permanentLandmark + ", permanentCity=" + permanentCity
				+ ", permanentPinCode=" + permanentPinCode + ", degree=" + degree + ", branch=" + branch + ", yop="
				+ yop + ", cgpa=" + cgpa + ", college_Name=" + collegeName + ", skills=" + skills
				+ ", yearsOfExperience=" + yearsOfExperience + ", dateOfAvailability=" + dateOfAvailability
				+ ", timestamp=" + timestamp + ", documents=" + documents + "]";
	}

	public void addDocument(TrainerDocument document) {
		documents.add(document);
		document.setTrainerInfo(this);
	}

	public void removeDocument(TrainerDocument document) {
		documents.remove(document);
		document.setTrainerInfo(null);
	}

}
