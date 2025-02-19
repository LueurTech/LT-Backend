package com.LT.Form.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LT.Form.entity.InternDocument;

import jakarta.transaction.Transactional;

/**
 * Repository for managing the InternDocument data
 * 
 * @author Mukund
 * @version 1.0
 *
 */

@Transactional
public interface InternDocumentRepository extends JpaRepository<InternDocument, String> {

    List<InternDocument> findByInternInfoId(Long internId);

}
