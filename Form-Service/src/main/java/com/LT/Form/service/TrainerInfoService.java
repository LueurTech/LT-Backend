package com.LT.Form.service;

import java.util.List;

import com.LT.Form.entity.TrainerInfo;

/**
 * Shows the list of services provided in TrainerInfo Document management
 * 
 * @author Mukund
 * @version 1.0
 *
 */
public interface TrainerInfoService {

    /**
     * Add the Trainer information into the system
     * 
     * @param internInfo
     * @return
     * @throws Exception
     */

    TrainerInfo addTrainerInfo(TrainerInfo trainerInfo) throws Exception;

    /**
     * Update the Trainer information in the system
     * 
     * @param internInfo
     * @return
     * @throws Exception
     */

    TrainerInfo updateTrainerInfo(TrainerInfo trainerInfo) throws Exception;

    /**
     * Gives the list of TrainerInfo in the system
     * 
     * @return
     * @throws Exception
     */
    List<TrainerInfo> listTrainerInfo() throws Exception;

    /**
     * Gives the Trainer information by Id
     * 
     * @param id
     * @return
     * @throws Exception
     */
    TrainerInfo getTrainerInfo(Long id) throws Exception;

    /**
     * delete the Trainer information by Id
     * 
     * @param id
     * @return
     * @throws Exception
     */
    void deleteTrainerInfo(Long id) throws Exception;

}
