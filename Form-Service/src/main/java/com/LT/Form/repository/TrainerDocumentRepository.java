package com.LT.Form.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LT.Form.entity.TrainerDocument;

/**
 * Repository for managing the Trainer Document data
 * 
 * @author Mukund
 * @version 1.0
 *
 */
public interface TrainerDocumentRepository extends JpaRepository<TrainerDocument, String> {

    List<TrainerDocument> findByTrainerInfoId(Long trainerId);
}
