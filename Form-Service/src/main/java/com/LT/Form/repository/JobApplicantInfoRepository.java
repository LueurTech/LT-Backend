package com.LT.Form.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LT.Form.entity.JobApplicantInfo;

/**
 * Repository for managing the JonApplicantInfo data
 * 
 * @author Mukund
 * @version 1.0
 *
 */

public interface JobApplicantInfoRepository extends JpaRepository<JobApplicantInfo, Long> {

}
