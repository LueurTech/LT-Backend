package com.LT.Form.service;

import java.util.List;

import com.LT.Form.entity.JobApplicantInfo;

/**
 * Shows the list of services provided in JobAplicantInfo management
 * 
 * @author Mukund
 * @version 1.0
 *
 */
public interface JobApplicantInfoService {

	/**
	 * Add the driver information into the system
	 * 
	 * @param jobApplicantInfo
	 * @return
	 * @throws Exception
	 */

	JobApplicantInfo addJobApplicantInfo(JobApplicantInfo jobApplicantInfo) throws Exception;

	// /**
	// * Update the JobAplicantMarks information in the system
	// *
	// * @param marksRequest
	// * @return
	// * @throws Exception
	// */

	// JobApplicantInfo updateJobApplicantMarks(JobApplicantMarksRequest
	// marksObject) throws Exception;

	/**
	 * Update the JobAplicantInfo information in the system
	 * 
	 * @param jobApplicantInfo
	 * @return
	 * @throws Exception
	 */

	JobApplicantInfo updateJobApplicantInfo(JobApplicantInfo jobApplicantInfo) throws Exception;

	/**
	 * Gives the list of jobApplicantInfo in the system
	 * 
	 * @return
	 * @throws Exception
	 */
	List<JobApplicantInfo> listJobApplicantInfo() throws Exception;

	/**
	 * Gives the jobApplicantInfo information by Id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	JobApplicantInfo getJobApplicantInfo(Long id) throws Exception;

	/**
	 * delete the jobApplicantInfo information by Id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	void deleteJobApplicantInfo(Long id) throws Exception;

}
