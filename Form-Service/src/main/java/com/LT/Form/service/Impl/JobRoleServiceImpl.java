package com.LT.Form.service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.Form.entity.JobRole;
import com.LT.Form.repository.JobRoleRepository;
import com.LT.Form.service.JobRoleService;

/**
 * Implementation class of JobRole service
 * 
 * @author Mukund
 * @version 1.0
 *
 */

@Service
public class JobRoleServiceImpl implements JobRoleService {

    @Autowired
    private JobRoleRepository jobRoleRepository;

    @Override
    public List<JobRole> getAllJobRoles() throws Exception {
        List<JobRole> jobRoles = jobRoleRepository.findAll();

        return jobRoles;
    }

    @Override
    public JobRole getJobRoleById(Long id) throws Exception {
        return jobRoleRepository.findById(id).orElseThrow(() -> new Exception("ERROR NOT FOUND"));
    }

    @Override
    public JobRole addJobRole(JobRole jobRole) throws Exception {
        if (jobRole == null)
            throw new RemoteException("Job Role cannot be empty");
        return jobRoleRepository.save(jobRole);
    }

    @Override
    public JobRole updateJobRole(JobRole jobRole) throws Exception {
        if (jobRole == null)
            throw new RemoteException("Job Role cannot be empty");
        return jobRoleRepository.save(jobRole);
    }

}
