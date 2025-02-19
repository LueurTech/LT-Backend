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
 * Entity class to maintain the Trainee Details information
 * 
 * @author Mukund
 * @version 1.0
 *
 */
@Entity
@Table(name = "TraineeDetails")
public class TraineeInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "training_course_id")
	private TrainingCourse trainingCourse;

	@Transient
	private Long trainingCourseId;

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

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "state", nullable = false)
	private String state;

	@Column(name = "landmark", nullable = false)
	private String landmark;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "pinCode", nullable = false)
	private String pinCode;

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

	@JsonIgnore
	@OneToMany(mappedBy = "traineeInfo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TraineeDocument> documents = new ArrayList<>();

	@Column(name = "timestamp")
	private Timestamp timestamp;

	public TraineeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TraineeInfo(long id, TrainingCourse trainingCourse, Long trainingCourseId, String name, String email,
			String phoneNo, String gender, Date dob, String address, String state, String landmark, String city,
			String pinCode, String degree, String branch, String yop, String cgpa, String collegeName, String skills,
			List<TraineeDocument> documents, Timestamp timestamp) {
		this.id = id;
		this.trainingCourse = trainingCourse;
		this.trainingCourseId = trainingCourseId;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.state = state;
		this.landmark = landmark;
		this.city = city;
		this.pinCode = pinCode;
		this.degree = degree;
		this.branch = branch;
		this.yop = yop;
		this.cgpa = cgpa;
		this.collegeName = collegeName;
		this.skills = skills;
		this.documents = documents;
		this.timestamp = timestamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TrainingCourse getTrainingCourse() {
		return trainingCourse;
	}

	public void setTrainingCourse(TrainingCourse trainingCourse) {
		this.trainingCourse = trainingCourse;
	}

	public Long getTrainingCourseId() {
		return trainingCourseId;
	}

	public void setTrainingCourseId(Long trainingCourseId) {
		this.trainingCourseId = trainingCourseId;
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

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
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

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public void addDocument(TraineeDocument document) {
		documents.add(document);
		document.setTraineeInfo(this);
	}

	public void removeDocument(TraineeDocument document) {
		documents.remove(document);
		document.setTraineeInfo(null);
	}

}
