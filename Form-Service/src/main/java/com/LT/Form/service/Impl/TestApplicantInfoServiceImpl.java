package com.LT.Form.service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.Form.dto.TestApplicantMarksRequest;
import com.LT.Form.entity.TestApplicantInfo;
import com.LT.Form.repository.TestApplicantInfoRepository;
import com.LT.Form.service.TestApplicantInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementation class of TestApplicantInfo service
 * 
 * @author Mukund
 * @version 1.0
 *
 */
@Slf4j
@Service
public class TestApplicantInfoServiceImpl implements TestApplicantInfoService {

    @Autowired
    TestApplicantInfoRepository testApplicantInfoRepository;

    @Override
    public TestApplicantInfo addTestApplicantInfo(TestApplicantInfo testApplicantInfo) throws Exception {
        if (testApplicantInfo == null)
            throw new RemoteException("Job Applicant Info Can't be empty");
        if (testApplicantInfo.getName() == null)
            throw new RemoteException("name can't be empty");
        return testApplicantInfoRepository.save(testApplicantInfo);
    }

    @Override
    public TestApplicantInfo updateTestApplicantInfo(TestApplicantInfo testApplicantInfo) throws Exception {
        if (testApplicantInfo == null)
            throw new RemoteException("Job Applicant Info Can't be empty");
        if (testApplicantInfo.getName() == null)
            throw new RemoteException("name can't be empty");
        return testApplicantInfoRepository.save(testApplicantInfo);
    }

    @Override
    public TestApplicantInfo updateTestApplicantMarks(TestApplicantMarksRequest marksObject) throws Exception {
        if (marksObject == null)
            throw new RemoteException("Job Applicant Marks Can't be empty");
        if (marksObject.getId() == null)
            throw new RemoteException("The TestApplicantId can't be empty");
        TestApplicantInfo testApplicantInfo = testApplicantInfoRepository.findById(marksObject.getId()).get();
        if (testApplicantInfo == null)
            throw new RemoteException("Job Applicant Info does not exist");
        testApplicantInfo.setTimestamp(marksObject.getTimestamp());
        testApplicantInfo.setTotalMarks(marksObject.getTotalMarks());
        testApplicantInfo.setObtainedMarks(marksObject.getObtainedMarks());

        return testApplicantInfoRepository.save(testApplicantInfo);
    }

    @Override
    public List<TestApplicantInfo> listTestApplicantInfo() throws Exception {

        List<TestApplicantInfo> testApplicantInfoList = testApplicantInfoRepository.findAll();

        return testApplicantInfoList;
    }

    @Override
    public TestApplicantInfo getTestApplicantInfo(Long id) throws Exception {

        if (id == null)
            throw new RemoteException("id can't be empty");

        TestApplicantInfo testApplicantInfo = testApplicantInfoRepository.findById(id).get();

        return testApplicantInfo;
    }

    @Override
    public void deleteTestApplicantInfo(Long id) throws Exception {

        if (id == null)
            throw new RemoteException("id can't be empty");

        testApplicantInfoRepository.deleteById(id);
    }

}
