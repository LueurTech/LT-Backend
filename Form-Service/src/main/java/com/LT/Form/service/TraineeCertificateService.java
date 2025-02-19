package com.LT.Form.service;

import java.util.List;

import com.LT.Form.entity.TraineeCertificateDetails;

/**
 * Shows the list of services provided in Trainee Certificate Details management
 * 
 * @author Mukund
 * @version 1.0
 *
 */

public interface TraineeCertificateService {
    /**
     * Add the Trainee Certificate related information into the system
     * 
     * @param traineeInfo
     * @return
     * @throws Exception
     */

    TraineeCertificateDetails addTraineecertificateDetails(TraineeCertificateDetails traineeCertificateDetails)
            throws Exception;

    /**
     * Update the Trainee Certificate related information in the system
     * 
     * @param traineeInfo
     * @return
     * @throws Exception
     */

    TraineeCertificateDetails updateTraineecertificateDetails(TraineeCertificateDetails traineeCertificateDetails)
            throws Exception;

    /**
     * Gives the list of Trainee Certificate related information from the system
     * 
     * @return
     * @throws Exception
     */
    List<TraineeCertificateDetails> listTraineeCertificateDetails() throws Exception;

    /**
     * Gives the Trainee Certificate related information by Id
     * 
     * @param id
     * @return
     * @throws Exception
     */
    TraineeCertificateDetails getTraineeCertificateDetails(Long id) throws Exception;

    /**
     * delete the Trainee Certificate related information by Id
     * 
     * @param id
     * @return
     * @throws Exception
     */
    void deleteTraineeCertificateDetails(Long id) throws Exception;

}
