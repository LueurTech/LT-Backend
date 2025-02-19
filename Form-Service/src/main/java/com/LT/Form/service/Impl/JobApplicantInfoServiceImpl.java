package com.LT.Form.service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.Form.entity.JobApplicantInfo;
import com.LT.Form.repository.JobApplicantInfoRepository;
import com.LT.Form.service.JobApplicantInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementation class of JobApplicantInfo service
 * 
 * @author Mukund
 * @version 1.0
 *
 */
@Slf4j
@Service
public class JobApplicantInfoServiceImpl implements JobApplicantInfoService {

	@Autowired
	JobApplicantInfoRepository jobApplicantInfoRepository;

	@Override
	public JobApplicantInfo addJobApplicantInfo(JobApplicantInfo jobApplicantInfo) throws Exception {
		if (jobApplicantInfo == null)
			throw new RemoteException("Job Applicant Info Can't be empty");
		if (jobApplicantInfo.getName() == null)
			throw new RemoteException("name can't be empty");
		return jobApplicantInfoRepository.save(jobApplicantInfo);
	}

	@Override
	public JobApplicantInfo updateJobApplicantInfo(JobApplicantInfo jobApplicantInfo) throws Exception {
		if (jobApplicantInfo == null)
			throw new RemoteException("Job Applicant Info Can't be empty");
		if (jobApplicantInfo.getName() == null)
			throw new RemoteException("name can't be empty");
		return jobApplicantInfoRepository.save(jobApplicantInfo);
	}

	// @Override
	// public JobApplicantInfo updateJobApplicantMarks(JobApplicantMarksRequest
	// marksObject) throws Exception {
	// if (marksObject == null)
	// throw new RemoteException("Job Applicant Marks Can't be empty");
	// if (marksObject.getId() == null)
	// throw new RemoteException("The JobApplicantId can't be empty");
	// JobApplicantInfo jobApplicantInfo =
	// jobApplicantInfoRepository.findById(marksObject.getId()).get();
	// if (jobApplicantInfo == null)
	// throw new RemoteException("Job Applicant Info does not exist");
	// // jobApplicantInfo.setTimestamp(marksObject.getTimestamp());
	// // jobApplicantInfo.setTotalMarks(marksObject.getTotalMarks());
	// // jobApplicantInfo.setObtainedMarks(marksObject.getObtainedMarks());

	// return jobApplicantInfoRepository.save(jobApplicantInfo);
	// }

	@Override
	public List<JobApplicantInfo> listJobApplicantInfo() throws Exception {

		List<JobApplicantInfo> jobApplicantInfoList = jobApplicantInfoRepository.findAll();

		return jobApplicantInfoList;
	}

	@Override
	public JobApplicantInfo getJobApplicantInfo(Long id) throws Exception {

		if (id == null)
			throw new RemoteException("id can't be empty");

		JobApplicantInfo jobApplicantInfo = jobApplicantInfoRepository.findById(id).get();

		return jobApplicantInfo;
	}

	@Override
	public void deleteJobApplicantInfo(Long id) throws Exception {

		if (id == null)
			throw new RemoteException("id can't be empty");

		jobApplicantInfoRepository.deleteById(id);
	}

}
