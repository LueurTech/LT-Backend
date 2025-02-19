package com.LT.Form.service;

import java.util.List;

import com.LT.Form.dto.TestApplicantMarksRequest;
import com.LT.Form.entity.TestApplicantInfo;

/**
 * Shows the list of services provided in JobAplicantInfo management
 * 
 * @author Mukund
 * @version 1.0
 *
 */
public interface TestApplicantInfoService {

    /**
     * Add the driver information into the system
     * 
     * @param jobApplicantInfo
     * @return
     * @throws Exception
     */

    TestApplicantInfo addTestApplicantInfo(TestApplicantInfo jobApplicantInfo) throws Exception;

    /**
     * Update the JobAplicantMarks information in the system
     * 
     * @param marksRequest
     * @return
     * @throws Exception
     */

    TestApplicantInfo updateTestApplicantMarks(TestApplicantMarksRequest marksObject) throws Exception;

    /**
     * Update the JobAplicantInfo information in the system
     * 
     * @param jobApplicantInfo
     * @return
     * @throws Exception
     */

    TestApplicantInfo updateTestApplicantInfo(TestApplicantInfo jobApplicantInfo) throws Exception;

    /**
     * Gives the list of jobApplicantInfo in the system
     * 
     * @return
     * @throws Exception
     */
    List<TestApplicantInfo> listTestApplicantInfo() throws Exception;

    /**
     * Gives the jobApplicantInfo information by Id
     * 
     * @param id
     * @return
     * @throws Exception
     */
    TestApplicantInfo getTestApplicantInfo(Long id) throws Exception;

    /**
     * delete the jobApplicantInfo information by Id
     * 
     * @param id
     * @return
     * @throws Exception
     */
    void deleteTestApplicantInfo(Long id) throws Exception;

}
