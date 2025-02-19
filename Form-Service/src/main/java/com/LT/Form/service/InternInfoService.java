package com.LT.Form.service;

import java.util.List;

import com.LT.Form.entity.InternInfo;

/**
 * Shows the list of services provided in JobAplicantInfo management
 * 
 * @author Mukund
 * @version 1.0
 *
 */
public interface InternInfoService {

    /**
     * Add the Intern information into the system
     * 
     * @param internInfo
     * @return
     * @throws Exception
     */

    InternInfo addInternInfo(InternInfo internInfo) throws Exception;

    /**
     * Update the Intern information in the system
     * 
     * @param internInfo
     * @return
     * @throws Exception
     */

    InternInfo updateInternInfo(InternInfo internInfo) throws Exception;

    /**
     * Gives the list of Intern in the system
     * 
     * @return
     * @throws Exception
     */
    List<InternInfo> listInternInfo() throws Exception;

    /**
     * Gives the Intern information by Id
     * 
     * @param id
     * @return
     * @throws Exception
     */
    InternInfo getInternInfo(Long id) throws Exception;

    /**
     * delete the Intern information by Id
     * 
     * @param id
     * @return
     * @throws Exception
     */
    void deleteInternInfo(Long id) throws Exception;

    /**
     * Gives the Intern information by Email
     * 
     * @param email
     * @return
     * @throws Exception
     */
    InternInfo getInternInfo(String email) throws Exception;

}
