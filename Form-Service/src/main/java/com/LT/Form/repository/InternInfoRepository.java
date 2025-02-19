package com.LT.Form.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LT.Form.entity.InternInfo;
import java.util.List;

/**
 * Repository for managing the JonApplicantInfo data
 * 
 * @author Dhruvil
 * @version 1.0
 *
 */

public interface InternInfoRepository extends JpaRepository<InternInfo, Long> {

    List<InternInfo> findByEmail(String email);
}
