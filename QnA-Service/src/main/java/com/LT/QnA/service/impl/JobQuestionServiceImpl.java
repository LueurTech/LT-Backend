package com.LT.QnA.service.impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.QnA.entity.JobQuestion;
import com.LT.QnA.repository.JobQuestionRepository;
import com.LT.QnA.service.JobQuestionService;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementation class of JobQuestion service
 * 
 * @author Dhruvil
 * @version 1.0
 *
 */

@Slf4j
@Service
public class JobQuestionServiceImpl implements JobQuestionService {

    @Autowired
    private JobQuestionRepository jobQuestionRepository;

    @Override
    public JobQuestion addJobQuestion(JobQuestion jobQuestion) throws Exception {
        if (jobQuestion == null) {
            throw new RemoteException("Job Question can't be empty");
        }
        return jobQuestionRepository.save(jobQuestion);
    }

    @Override
    public JobQuestion updatJobQuestion(JobQuestion jobQuestion) throws Exception {
        if (jobQuestion == null) {
            throw new RemoteException("Job Question can't be empty");
        }
        return jobQuestionRepository.save(jobQuestion);
    }

    @Override
    public List<JobQuestion> getJobQuestionsByType(String questionType) throws Exception {
        if (questionType == null) {
            throw new RemoteException("Question Type can't be empty");
        }
        return jobQuestionRepository.findByQuestionType(questionType);
    }

    @Override
    public List<JobQuestion> getJobQuestionByProgrammingLanguage(String progammingLanguage) throws Exception {
        if (progammingLanguage == null) {
            throw new RemoteException("Programming Langauge can't be empty");
        }
        return jobQuestionRepository.findByProgrammingLanguage(progammingLanguage);
    }

    @Override
    public void deleteJobQuestion(Long id) throws Exception {
        if (id == null) {
            throw new RemoteException("Id can't be empty");
        }
        jobQuestionRepository.deleteById(id);
    }

}
