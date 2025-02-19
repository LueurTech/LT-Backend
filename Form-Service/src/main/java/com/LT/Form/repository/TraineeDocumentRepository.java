package com.LT.Form.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LT.Form.entity.TraineeDocument;

import jakarta.transaction.Transactional;

/**
 * Repository for managing the TraineeDocument data
 * 
 * @author Mukund
 * @version 1.0
 *
 */

@Transactional
public interface TraineeDocumentRepository extends JpaRepository<TraineeDocument, String> {

    List<TraineeDocument> findByTraineeInfoId(Long traineeId);

}
