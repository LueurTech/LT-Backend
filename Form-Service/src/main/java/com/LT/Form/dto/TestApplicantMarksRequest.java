package com.LT.Form.dto;

import java.sql.Timestamp;

public class TestApplicantMarksRequest {

    private Long id;

    private Timestamp timestamp;

    private Long totalMarks;

    private Long obtainedMarks;

    public TestApplicantMarksRequest() {
    }

    public TestApplicantMarksRequest(Long id, Timestamp timestamp, Long totalMarks, Long obtainedMarks) {
        this.id = id;
        this.timestamp = timestamp;
        this.totalMarks = totalMarks;
        this.obtainedMarks = obtainedMarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Long getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Long totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Long getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(Long obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }

}
