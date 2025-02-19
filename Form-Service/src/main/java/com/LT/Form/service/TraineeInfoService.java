package com.LT.Form.service;

import java.util.List;

import com.LT.Form.entity.TraineeInfo;

/**
 * Shows the list of services provided in TraineeInfo Document management
 * 
 * @author Mukund
 * @version 1.0
 *
 */
public interface TraineeInfoService {
    /**
     * Add the Trainee information into the system
     * 
     * @param internInfo
     * @return
     * @throws Exception
     */

    TraineeInfo addTraineeInfo(TraineeInfo traineeInfo) throws Exception;

    /**
     * Update the Trainee information in the system
     * 
     * @param internInfo
     * @return
     * @throws Exception
     */

    TraineeInfo updateTraineeInfo(TraineeInfo traineeInfo) throws Exception;

    /**
     * Gives the list of TraineeInfo in the system
     * 
     * @return
     * @throws Exception
     */
    List<TraineeInfo> listTraineeInfo() throws Exception;

    /**
     * Gives the Trainee information by Id
     * 
     * @param id
     * @return
     * @throws Exception
     */
    TraineeInfo getTraineeInfo(Long id) throws Exception;

    /**
     * delete the Trainee information by Id
     * 
     * @param id
     * @return
     * @throws Exception
     */
    void deleteTraineeInfo(Long id) throws Exception;

    /**
     * Gives the Trainee information by Id
     * 
     * @param email
     * @return
     * @throws Exception
     */
    TraineeInfo getTraineeInfo(String email) throws Exception;
}
