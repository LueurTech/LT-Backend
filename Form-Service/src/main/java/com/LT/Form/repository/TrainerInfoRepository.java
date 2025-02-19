package com.LT.Form.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LT.Form.entity.TrainerInfo;

/**
 * Repository for managing the TrainerInfo data
 * 
 * @author Mukund
 * @version 1.0
 *
 */
public interface TrainerInfoRepository  extends JpaRepository<TrainerInfo, Long> {

}
