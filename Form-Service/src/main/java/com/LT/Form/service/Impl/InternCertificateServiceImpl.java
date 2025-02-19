package com.LT.Form.service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.Form.entity.InternCertificateDetails;
import com.LT.Form.repository.InternCertificateRepository;
import com.LT.Form.service.InternCertificateService;

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
public class InternCertificateServiceImpl implements InternCertificateService {

	@Autowired
	InternCertificateRepository internCertificateRepository;

	// @Override
	// public InternCertificateDetails
	// addInterncertificateDetails(InternCertificateDetails
	// internCertificateDetails) throws Exception {
	//
	// if (internCertificateDetails == null)
	// throw new RemoteException("Intern Certificate Details Can't be empty");
	// if (internCertificateDetails.getName() == null)
	// throw new RemoteException("name can't be empty");
	// if (internCertificateDetails.getEmail() == null)
	// throw new RemoteException("Email can't be empty");
	// if (internCertificateDetails.getPhoneNo() == null)
	// throw new RemoteException("Phone No can't be empty");
	// return internCertificateRepository.save(internCertificateDetails);
	//
	// }

	@Override
	public InternCertificateDetails addInterncertificateDetails(InternCertificateDetails internCertificateDetails)
			throws Exception {
		// Check if email or phone number already exists
		InternCertificateDetails existingCertificateWithEmail = internCertificateRepository
				.findByEmail(internCertificateDetails.getEmail());
		InternCertificateDetails existingCertificateWithPhone = internCertificateRepository
				.findByPhoneNo(internCertificateDetails.getPhoneNo());

		if (existingCertificateWithEmail != null) {
			throw new Exception("Email already exists");
		}

		if (existingCertificateWithPhone != null) {
			throw new Exception("Phone number already exists");
		}

		if (internCertificateDetails.getName() == null)
			throw new RemoteException("name can't be empty");
		if (internCertificateDetails.getEmail() == null)
			throw new RemoteException("Email can't be empty");
		if (internCertificateDetails.getPhoneNo() == null)
			throw new RemoteException("Phone No can't be empty");

		return internCertificateRepository.save(internCertificateDetails);
	}

	@Override
	public InternCertificateDetails updateInterncertificateDetails(InternCertificateDetails internCertificateDetails)
			throws Exception {
		if (internCertificateDetails == null)
			throw new RemoteException("Job Applicant Info Can't be empty");
		if (internCertificateDetails.getName() == null)
			throw new RemoteException("name can't be empty");
		return internCertificateRepository.save(internCertificateDetails);
	}

	@Override
	public List<InternCertificateDetails> listInternCertificateDetails() throws Exception {
		List<InternCertificateDetails> internCertificateDetailsList = internCertificateRepository.findAll();

		return internCertificateDetailsList;
	}

	@Override
	public InternCertificateDetails getInternCertificateDetails(Long id) throws Exception {
		if (id == null)
			throw new RemoteException("id can't be empty");

		InternCertificateDetails internCertificateDetails = internCertificateRepository.findById(id).get();

		return internCertificateDetails;
	}

	@Override
	public void deleteInternCertificateDetails(Long id) throws Exception {
		if (id == null)
			throw new RemoteException("id can't be empty");

		internCertificateRepository.deleteById(id);

	}

}
