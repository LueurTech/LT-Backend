package com.LT.Form.entity;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entity class to maintain the TestApplicantInfo information
 * 
 * @author Mukund
 * @version 1.0
 *
 */

@Entity
@Table(name = "TestApplicantDocument")
public class TestApplicantDocument {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String fileId;

    @Column(name = "fileName", nullable = false)
    private String fileName;

    @Column(name = "fileType", nullable = false)
    private String fileType;

    @Lob
    @Column(name = "data", columnDefinition = "LONGBLOB", nullable = false)
    private byte[] data;

    // @Column(name = "applicantId", nullable = false)
    // private long applicantId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "testApplicantInfoId")
    private TestApplicantInfo testApplicantInfo;

    public TestApplicantDocument() {
    }

    public TestApplicantDocument(String fileId, String fileName, String fileType, byte[] data,
            TestApplicantInfo testApplicantInfo) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        // this.applicantId = applicantId;
        this.testApplicantInfo = testApplicantInfo;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    // public long getApplicantId() {
    // return applicantId;
    // }

    // public void setApplicantId(long applicantId) {
    // this.applicantId = applicantId;
    // }

    public TestApplicantInfo getTestApplicantInfo() {
        return testApplicantInfo;
    }

    public void setTestApplicantInfo(TestApplicantInfo applicantInfo) {
        this.testApplicantInfo = applicantInfo;
    }

}
