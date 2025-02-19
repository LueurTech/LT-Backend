package com.LT.QnA.service;

import java.util.List;

import com.LT.QnA.entity.JobQuestion;

import lombok.extern.slf4j.Slf4j;

/**
 * Shows the list of services provided in JobQuestion management
 * 
 * @author Dhruvil
 * @version 1.0
 *
 */

public interface JobQuestionService {

    JobQuestion addJobQuestion(JobQuestion jobQuestion) throws Exception;

    JobQuestion updatJobQuestion(JobQuestion jobQuestion) throws Exception;

    List<JobQuestion> getJobQuestionsByType(String questionType) throws Exception;

    List<JobQuestion> getJobQuestionByProgrammingLanguage(String progammingLanguage) throws Exception;

    void deleteJobQuestion(Long id) throws Exception;

}
