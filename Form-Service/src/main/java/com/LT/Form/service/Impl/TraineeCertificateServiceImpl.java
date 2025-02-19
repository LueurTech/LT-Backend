package com.LT.Form.service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.Form.entity.TraineeCertificateDetails;
import com.LT.Form.repository.TraineeCertificateRepository;
import com.LT.Form.service.TraineeCertificateService;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementation class of TraineeInfo service
 * 
 * @author Mukund
 * @version 1.0
 *
 */
@Slf4j
@Service
public class TraineeCertificateServiceImpl implements TraineeCertificateService {

    @Autowired
    TraineeCertificateRepository traineeCertificateRepository;

    // @Override
    // public TraineeCertificateDetails
    // addTraineecertificateDetails(TraineeCertificateDetails
    // traineeCertificateDetails) throws Exception {
    //
    // if (traineeCertificateDetails == null)
    // throw new RemoteException("Trainee Certificate Details Can't be empty");
    // if (traineeCertificateDetails.getName() == null)
    // throw new RemoteException("name can't be empty");
    // if (traineeCertificateDetails.getEmail() == null)
    // throw new RemoteException("Email can't be empty");
    // if (traineeCertificateDetails.getPhoneNo() == null)
    // throw new RemoteException("Phone No can't be empty");
    // return traineeCertificateRepository.save(traineeCertificateDetails);
    //
    // }

    @Override
    public TraineeCertificateDetails addTraineecertificateDetails(TraineeCertificateDetails traineeCertificateDetails)
            throws Exception {
        // Check if email or phone number already exists
        TraineeCertificateDetails existingCertificateWithEmail = traineeCertificateRepository
                .findByEmail(traineeCertificateDetails.getEmail());
        TraineeCertificateDetails existingCertificateWithPhone = traineeCertificateRepository
                .findByPhoneNo(traineeCertificateDetails.getPhoneNo());

        if (existingCertificateWithEmail != null) {
            throw new Exception("Email already exists");
        }

        if (existingCertificateWithPhone != null) {
            throw new Exception("Phone number already exists");
        }

        if (traineeCertificateDetails.getName() == null)
            throw new RemoteException("name can't be empty");
        if (traineeCertificateDetails.getEmail() == null)
            throw new RemoteException("Email can't be empty");
        if (traineeCertificateDetails.getPhoneNo() == null)
            throw new RemoteException("Phone No can't be empty");

        return traineeCertificateRepository.save(traineeCertificateDetails);
    }

    @Override
    public TraineeCertificateDetails updateTraineecertificateDetails(
            TraineeCertificateDetails traineeCertificateDetails)
            throws Exception {
        if (traineeCertificateDetails == null)
            throw new RemoteException("Job Applicant Info Can't be empty");
        if (traineeCertificateDetails.getName() == null)
            throw new RemoteException("name can't be empty");
        return traineeCertificateRepository.save(traineeCertificateDetails);
    }

    @Override
    public List<TraineeCertificateDetails> listTraineeCertificateDetails() throws Exception {
        List<TraineeCertificateDetails> traineeCertificateDetailsList = traineeCertificateRepository.findAll();

        return traineeCertificateDetailsList;
    }

    @Override
    public TraineeCertificateDetails getTraineeCertificateDetails(Long id) throws Exception {
        if (id == null)
            throw new RemoteException("id can't be empty");

        TraineeCertificateDetails traineeCertificateDetails = traineeCertificateRepository.findById(id).get();

        return traineeCertificateDetails;
    }

    @Override
    public void deleteTraineeCertificateDetails(Long id) throws Exception {
        if (id == null)
            throw new RemoteException("id can't be empty");

        traineeCertificateRepository.deleteById(id);

    }

}
