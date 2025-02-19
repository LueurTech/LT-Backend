package com.LT.Form.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LT.Form.entity.JobRole;

/**
 * Repository for managing the JobRole data
 * 
 * @author Mukund
 * @version 1.0
 *
 */

public interface JobRoleRepository extends JpaRepository<JobRole, Long> {

}
