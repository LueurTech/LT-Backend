package com.LT.Form.service;

import java.util.List;

import com.LT.Form.entity.JobRole;

/**
 * Shows the list of services provided in JobRole management
 * 
 * @author Mukund
 * @version 1.0
 *
 */

public interface JobRoleService {

    JobRole getJobRoleById(Long id) throws Exception;

    List<JobRole> getAllJobRoles() throws Exception;

    JobRole addJobRole(JobRole jobRole) throws Exception;

    JobRole updateJobRole(JobRole jobRole) throws Exception;
}
