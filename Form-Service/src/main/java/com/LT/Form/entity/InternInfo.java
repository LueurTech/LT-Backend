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
 * @author Dhruvil
 * @version 1.0
 *
 */

@Entity
@Table(name = "InternInfo")
public class InternInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "domain_id")
    private Domain domain;

    @Transient
    private Long domainId;

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

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "degree", nullable = false)
    private String degree;

    @Column(name = "branch", nullable = false)
    private String branch;

    @Column(name = "yop", nullable = false)
    private String yop;

    @Column(name = "cgpa", nullable = false)
    private String cgpa;

    @Column(name = "college_Name", nullable = false)
    private String college_Name;

    @Column(name = "yop_12", nullable = false)
    private String yop_12;

    @Column(name = "percentage_12", nullable = false)
    private String percentage_12;

    @Column(name = "college_12", nullable = false)
    private String college_12;

    @Column(name = "yop_10", nullable = false)
    private String yop_10;

    @Column(name = "percentage_10", nullable = false)
    private String percentage_10;

    @Column(name = "school_10", nullable = false)
    private String school_10;

    @Column(name = "active_Backlog", nullable = false)
    private int active_Backlog;

    @Temporal(TemporalType.DATE)
    @Column(name = "startDate", nullable = true)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "endDate", nullable = true)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date endDate;

    @Column(name = "duration")
    private String duration;

    @Column(name = "typeOfInternship")
    private String typeOfInternship;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @JsonIgnore
    @OneToMany(mappedBy = "internInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InternDocument> documents = new ArrayList<>();

    public InternInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

    public InternInfo(long id, Domain domain, Long domainId, String name, String email, String phoneNo, String gender,
            Date dob, String city, String degree, String branch, String yop, String cgpa, String college_Name,
            String yop_12, String percentage_12, String college_12, String yop_10, String percentage_10,
            String school_10, int active_Backlog, Date startDate, Date endDate, String duration,
            String typeOfInternship, Timestamp timestamp, List<InternDocument> documents) {
        this.id = id;
        this.domain = domain;
        this.domainId = domainId;
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
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.typeOfInternship = typeOfInternship;
        this.timestamp = timestamp;
        this.documents = documents;
    }

    public long getId() {
        return id;
    }

    public void setId(long studentid) {
        this.id = studentid;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
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

    public List<InternDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(List<InternDocument> documents) {
        this.documents = documents;
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

    public String getTypeOfInternship() {
        return typeOfInternship;
    }

    public void setTypeOfInternship(String typeOfInternship) {
        this.typeOfInternship = typeOfInternship;
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

    @Override
    public String toString() {
        return "InternInfo [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", gender="
                + gender + ", dob=" + dob + ", city=" + city + ", degree=" + degree + ", branch=" + branch + ", yop="
                + yop + ", cgpa=" + cgpa + ", college_Name=" + college_Name + ", yop_12=" + yop_12 + ", percentage_12="
                + percentage_12 + ", college_12=" + college_12 + ", yop_10=" + yop_10 + ", percentage_10="
                + percentage_10 + ", school_10=" + school_10 + ", active_Backlog=" + active_Backlog + ", timestamp="
                + timestamp + ", duration=" + duration + ", documents="
                + documents + "]";
    }

    public void addDocument(InternDocument document) {
        documents.add(document);
        document.setInternInfo(this);
    }

    public void removeDocument(InternDocument document) {
        documents.remove(document);
        document.setInternInfo(null);
    }

}
