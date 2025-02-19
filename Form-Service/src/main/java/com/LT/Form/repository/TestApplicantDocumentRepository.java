package com.LT.Form.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LT.Form.entity.TestApplicantDocument;

import jakarta.transaction.Transactional;

/**
 * Repository for managing the JonApplicantInfo data
 * 
 * @author Mukund
 * @version 1.0
 *
 */

@Transactional
public interface TestApplicantDocumentRepository extends JpaRepository<TestApplicantDocument, String> {

    List<TestApplicantDocument> findByTestApplicantInfoId(Long applicantId);
}
