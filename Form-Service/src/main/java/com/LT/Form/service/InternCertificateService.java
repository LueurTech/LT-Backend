package com.LT.Form.service;

import java.util.List;

import com.LT.Form.entity.InternCertificateDetails;

/**
 * Shows the list of services provided in Intern Certificate Details management
 * 
 * @author Mukund
 * @version 1.0
 *
 */

public interface InternCertificateService {
    /**
     * Add the Intern Certificate related information into the system
     * 
     * @param internInfo
     * @return
     * @throws Exception
     */

    InternCertificateDetails addInterncertificateDetails(InternCertificateDetails internCertificateDetails)
            throws Exception;

    /**
     * Update the Intern Certificate related information in the system
     * 
     * @param internInfo
     * @return
     * @throws Exception
     */

    InternCertificateDetails updateInterncertificateDetails(InternCertificateDetails internCertificateDetails)
            throws Exception;

    /**
     * Gives the list of Intern Certificate related information from the system
     * 
     * @return
     * @throws Exception
     */
    List<InternCertificateDetails> listInternCertificateDetails() throws Exception;

    /**
     * Gives the Intern Certificate related information by Id
     * 
     * @param id
     * @return
     * @throws Exception
     */
    InternCertificateDetails getInternCertificateDetails(Long id) throws Exception;

    /**
     * delete the Intern Certificate related information by Id
     * 
     * @param id
     * @return
     * @throws Exception
     */
    void deleteInternCertificateDetails(Long id) throws Exception;

}
