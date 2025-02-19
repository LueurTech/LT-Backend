package com.LT.Form.service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.Form.entity.InternInfo;
import com.LT.Form.repository.InternInfoRepository;
import com.LT.Form.service.InternInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementation class of InternInfo service
 * 
 * @author Mukund
 * @version 1.0
 *
 */
@Slf4j
@Service
public class InternInfoServiceImpl implements InternInfoService {

    @Autowired
    InternInfoRepository internInfoRepository;

    @Override
    public InternInfo addInternInfo(InternInfo internInfo) throws Exception {
        if (internInfo == null)
            throw new RemoteException("Job Applicant Info Can't be empty");
        if (internInfo.getName() == null)
            throw new RemoteException("name can't be empty");
        return internInfoRepository.save(internInfo);
    }

    @Override
    public InternInfo updateInternInfo(InternInfo internInfo) throws Exception {
        if (internInfo == null)
            throw new RemoteException("Job Applicant Info Can't be empty");
        if (internInfo.getName() == null)
            throw new RemoteException("name can't be empty");
        return internInfoRepository.save(internInfo);
    }

    @Override
    public List<InternInfo> listInternInfo() throws Exception {

        List<InternInfo> internInfoList = internInfoRepository.findAll();

        return internInfoList;
    }

    @Override
    public InternInfo getInternInfo(Long id) throws Exception {

        if (id == null)
            throw new RemoteException("id can't be empty");

        InternInfo internInfo = internInfoRepository.findById(id).get();

        return internInfo;
    }

    @Override
    public void deleteInternInfo(Long id) throws Exception {

        if (id == null)
            throw new RemoteException("id can't be empty");

        internInfoRepository.deleteById(id);
    }

    @Override
    public InternInfo getInternInfo(String email) throws Exception {
        if (email == null)
            throw new RemoteException("email can't be empty");

        return internInfoRepository.findByEmail(email).get(0);
    }

}
