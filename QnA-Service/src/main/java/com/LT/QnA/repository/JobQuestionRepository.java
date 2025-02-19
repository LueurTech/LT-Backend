package com.LT.QnA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.LT.QnA.entity.JobQuestion;

import jakarta.transaction.Transactional;

/**
 * Repository for managing the JobQuestion data
 * 
 * @author Dhruvil
 * @version 1.0
 *
 */
@Transactional
public interface JobQuestionRepository extends JpaRepository<JobQuestion, Long> {

    @Query("SELECT e FROM JobQuestion e WHERE e.questionType = :questionType")
    List<JobQuestion> findByQuestionType(String questionType);

    @Query("SELECT e from JobQuestion e WHERE e.programmingLanguage = :programmingLanguage")
    List<JobQuestion> findByProgrammingLanguage(String programmingLanguage);

}
