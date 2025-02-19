package com.LT.Form.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LT.Form.entity.TraineeInfo;
import java.util.List;

/**
 * Repository for managing the TraineeInfo data
 * 
 * @author Mukund
 * @version 1.0
 *
 */
public interface TraineeInfoRepository extends JpaRepository<TraineeInfo, Long> {

    List<TraineeInfo> findByEmail(String email);
}
