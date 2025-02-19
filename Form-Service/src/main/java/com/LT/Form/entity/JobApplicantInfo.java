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
 * Entity class to maintain the JobApplicantInfo information
 * 
 * @author Mukund
 * @version 1.0
 *
 */

@Entity
@Table(name = "JobApplicantInfo")
public class JobApplicantInfo {

	// PERSONAL INFORMATION
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

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "phoneNo", nullable = false)
	private String phoneNo;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Temporal(TemporalType.DATE)
	@Column(name = "dob", nullable = true)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dob;

	@Column(name = "current_address", nullable = false, columnDefinition = "LONGTEXT")
	private String currentAddress;

	@Column(name = "current_city", nullable = false)
	private String currentCity;

	@Column(name = "current_state", nullable = false)
	private String currentState;

	@Column(name = "current_pincode", nullable = false)
	private String currentPincode;

	@Column(name = "permanent_address", nullable = false, columnDefinition = "LONGTEXT")
	private String permanentAddress;

	@Column(name = "permanent_city", nullable = false)
	private String permanentCity;

	@Column(name = "permanent_state", nullable = false)
	private String permanentState;

	@Column(name = "permanent_pincode", nullable = false)
	private String permanentPincode;

	// ACADEMIC INFORMATION
	// Masters
	@Column(name = "masters_degree", nullable = true)
	private String mastersDegree;

	@Column(name = "masters_branch", nullable = true)
	private String mastersBranch;

	@Column(name = "masters_yop", nullable = true)
	private String mastersYOP;

	@Column(name = "masters_cgpa", nullable = true)
	private String mastersCGPA;

	@Column(name = "masters_college_name", nullable = true)
	private String mastersCollegeName;

	@Column(name = "masters_active_backlog", nullable = true)
	private String mastersActiveBacklog;

	// Bachelors
	@Column(name = "bachelors_degree", nullable = true)
	private String bachelorsDegree;

	@Column(name = "bachelors_branch", nullable = true)
	private String bachelorsBranch;

	@Column(name = "bachelors_yop", nullable = true)
	private String bachelorsYOP;

	@Column(name = "bachelors_cgpa", nullable = true)
	private String bachelorsCGPA;

	@Column(name = "bachelors_college_name", nullable = true)
	private String bachelorsCollegeName;

	@Column(name = "bachelors_active_backlog", nullable = true)
	private String bachelorsActiveBacklog;

	// 12th
	@Column(name = "yop_12", nullable = true)
	private String yop_12;

	@Column(name = "percentage_12", nullable = true)
	private String percentage_12;

	@Column(name = "college_12", nullable = true)
	private String college_12;

	// 10th
	@Column(name = "yop_10", nullable = true)
	private String yop_10;

	@Column(name = "percentage_10", nullable = true)
	private String percentage_10;

	@Column(name = "school_10", nullable = true)
	private String school_10;

	@Column(name = "academic_gap", nullable = true)
	private String academicGap;

	// PROFESSIONAL INFORMATION
	@Column(name = "linkedin_profile", nullable = true)
	private String linkedInProfile;

	@Column(name = "recent_employer", nullable = true)
	private String recentEmployer;

	@Column(name = "recent_designation", nullable = true)
	private String recentDesignation;

	@Column(name = "recent_notice_period", nullable = true)
	private String recentNoticePeriod;

	@Column(name = "recent_years_of_exp", nullable = true)
	private String recentYearsOfExp;

	@Column(name = "total_years_of_exp", nullable = true)
	private String totalYearsOfExp;

	@Column(name = "recent_ctc", nullable = true)
	private String recentCTC;

	@Column(name = "expected_ctc", nullable = true)
	private String expectedCTC;

	@Column(name = "skills", nullable = true, columnDefinition = "TINYTEXT")
	private String skills;

	@Column(name = "available_to_join", nullable = true)
	private String availableToJoin;

	@Column(name = "timestamp")
	private Timestamp timestamp;

	@JsonIgnore
	@OneToMany(mappedBy = "jobApplicantInfo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<JobApplicantDocument> documents = new ArrayList<>();

	public JobApplicantInfo() {
		super();
	}

	public JobApplicantInfo(long id, String name, String email, String phoneNo, String gender, Date dob,
			String currentAddress, String currentCity, String currentState, String currentPincode,
			String permanentAddress, String permanentCity, String permanentState, String permanentPincode,
			String mastersDegree, String mastersBranch, String mastersYOP, String mastersCGPA,
			String mastersCollegeName, String mastersActiveBacklog, String bachelorsDegree, String bachelorsBranch,
			String bachelorsYOP, String bachelorsCGPA, String bachelorsCollegeName, String bachelorsActiveBacklog,
			String yop_12, String percentage_12, String college_12, String yop_10, String percentage_10,
			String school_10, String academicGap, String linkedInProfile, String recentEmployer,
			String recentDesignation,
			String recentNoticePeriod, String recentYearsOfExp, String totalYearsOfExp, String recentCTC,
			String expectedCTC,
			String skills, String availableToJoin, Timestamp timestamp) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.dob = dob;
		this.currentAddress = currentAddress;
		this.currentCity = currentCity;
		this.currentState = currentState;
		this.currentPincode = currentPincode;
		this.permanentAddress = permanentAddress;
		this.permanentCity = permanentCity;
		this.permanentState = permanentState;
		this.permanentPincode = permanentPincode;
		this.mastersDegree = mastersDegree;
		this.mastersBranch = mastersBranch;
		this.mastersYOP = mastersYOP;
		this.mastersCGPA = mastersCGPA;
		this.mastersCollegeName = mastersCollegeName;
		this.mastersActiveBacklog = mastersActiveBacklog;
		this.bachelorsDegree = bachelorsDegree;
		this.bachelorsBranch = bachelorsBranch;
		this.bachelorsYOP = bachelorsYOP;
		this.bachelorsCGPA = bachelorsCGPA;
		this.bachelorsCollegeName = bachelorsCollegeName;
		this.bachelorsActiveBacklog = bachelorsActiveBacklog;
		this.yop_12 = yop_12;
		this.percentage_12 = percentage_12;
		this.college_12 = college_12;
		this.yop_10 = yop_10;
		this.percentage_10 = percentage_10;
		this.school_10 = school_10;
		this.academicGap = academicGap;
		this.linkedInProfile = linkedInProfile;
		this.recentEmployer = recentEmployer;
		this.recentDesignation = recentDesignation;
		this.recentNoticePeriod = recentNoticePeriod;
		this.recentYearsOfExp = recentYearsOfExp;
		this.totalYearsOfExp = totalYearsOfExp;
		this.recentCTC = recentCTC;
		this.expectedCTC = expectedCTC;
		this.skills = skills;
		this.availableToJoin = availableToJoin;
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

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public String getCurrentPincode() {
		return currentPincode;
	}

	public void setCurrentPincode(String currentPincode) {
		this.currentPincode = currentPincode;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPermanentCity() {
		return permanentCity;
	}

	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}

	public String getPermanentState() {
		return permanentState;
	}

	public void setPermanentState(String permanentState) {
		this.permanentState = permanentState;
	}

	public String getPermanentPincode() {
		return permanentPincode;
	}

	public void setPermanentPincode(String permanentPincode) {
		this.permanentPincode = permanentPincode;
	}

	public String getMastersDegree() {
		return mastersDegree;
	}

	public void setMastersDegree(String mastersDegree) {
		this.mastersDegree = mastersDegree;
	}

	public String getMastersBranch() {
		return mastersBranch;
	}

	public void setMastersBranch(String mastersBranch) {
		this.mastersBranch = mastersBranch;
	}

	public String getMastersYOP() {
		return mastersYOP;
	}

	public void setMastersYOP(String mastersYOP) {
		this.mastersYOP = mastersYOP;
	}

	public String getMastersCGPA() {
		return mastersCGPA;
	}

	public void setMastersCGPA(String mastersCGPA) {
		this.mastersCGPA = mastersCGPA;
	}

	public String getMastersCollegeName() {
		return mastersCollegeName;
	}

	public void setMastersCollegeName(String mastersCollegeName) {
		this.mastersCollegeName = mastersCollegeName;
	}

	public String getMastersActiveBacklog() {
		return mastersActiveBacklog;
	}

	public void setMastersActiveBacklog(String mastersActiveBacklog) {
		this.mastersActiveBacklog = mastersActiveBacklog;
	}

	public String getBachelorsDegree() {
		return bachelorsDegree;
	}

	public void setBachelorsDegree(String bachelorsDegree) {
		this.bachelorsDegree = bachelorsDegree;
	}

	public String getBachelorsBranch() {
		return bachelorsBranch;
	}

	public void setBachelorsBranch(String bachelorsBranch) {
		this.bachelorsBranch = bachelorsBranch;
	}

	public String getBachelorsYOP() {
		return bachelorsYOP;
	}

	public void setBachelorsYOP(String bachelorsYOP) {
		this.bachelorsYOP = bachelorsYOP;
	}

	public String getBachelorsCGPA() {
		return bachelorsCGPA;
	}

	public void setBachelorsCGPA(String bachelorsCGPA) {
		this.bachelorsCGPA = bachelorsCGPA;
	}

	public String getBachelorsCollegeName() {
		return bachelorsCollegeName;
	}

	public void setBachelorsCollegeName(String bachelorsCollegeName) {
		this.bachelorsCollegeName = bachelorsCollegeName;
	}

	public String getBachelorsActiveBacklog() {
		return bachelorsActiveBacklog;
	}

	public void setBachelorsActiveBacklog(String bachelorsActiveBacklog) {
		this.bachelorsActiveBacklog = bachelorsActiveBacklog;
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

	public String getAcademicGap() {
		return academicGap;
	}

	public void setAcademicGap(String academicGap) {
		this.academicGap = academicGap;
	}

	public String getLinkedInProfile() {
		return linkedInProfile;
	}

	public void setLinkedInProfile(String linkedInProfile) {
		this.linkedInProfile = linkedInProfile;
	}

	public String getRecentEmployer() {
		return recentEmployer;
	}

	public void setRecentEmployer(String recentEmployer) {
		this.recentEmployer = recentEmployer;
	}

	public String getRecentDesignation() {
		return recentDesignation;
	}

	public void setRecentDesignation(String recentDesignation) {
		this.recentDesignation = recentDesignation;
	}

	public String getRecentNoticePeriod() {
		return recentNoticePeriod;
	}

	public void setRecentNoticePeriod(String recentNoticePeriod) {
		this.recentNoticePeriod = recentNoticePeriod;
	}

	public String getRecentYearsOfExp() {
		return recentYearsOfExp;
	}

	public void setRecentYearsOfExp(String recentYearsOfExp) {
		this.recentYearsOfExp = recentYearsOfExp;
	}

	public String getTotalYearsOfExp() {
		return totalYearsOfExp;
	}

	public void setTotalYearsOfExp(String totalYearsOfExp) {
		this.totalYearsOfExp = totalYearsOfExp;
	}

	public String getRecentCTC() {
		return recentCTC;
	}

	public void setRecentCTC(String recentCTC) {
		this.recentCTC = recentCTC;
	}

	public String getExpectedCTC() {
		return expectedCTC;
	}

	public void setExpectedCTC(String expectedCTC) {
		this.expectedCTC = expectedCTC;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getAvailableToJoin() {
		return availableToJoin;
	}

	public void setAvailableToJoin(String availableToJoin) {
		this.availableToJoin = availableToJoin;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public void addDocument(JobApplicantDocument document) {
		documents.add(document);
		document.setJobApplicantInfo(this);
	}

	public void removeDocument(JobApplicantDocument document) {
		documents.remove(document);
		document.setJobApplicantInfo(null);

	}

}
