package com.LT.Form.service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.Form.entity.TraineeInfo;
import com.LT.Form.repository.TraineeInfoRepository;
import com.LT.Form.service.TraineeInfoService;

/**
 * Implementation class of TraineeInfo service Implementation
 * 
 * @author Mukund
 * @version 1.0
 *
 */

@Service
public class TraineeInfoServiceImpl implements TraineeInfoService {

	@Autowired
	private TraineeInfoRepository traineeInfoRepository;

	@Override
	public TraineeInfo addTraineeInfo(TraineeInfo traineeInfo) throws Exception {
		if (traineeInfo == null)
			throw new RemoteException("Trainee Applicant Info Can't be empty");
		if (traineeInfo.getName() == null)
			throw new RemoteException("name can't be empty");
		return traineeInfoRepository.save(traineeInfo);
	}

	@Override
	public TraineeInfo updateTraineeInfo(TraineeInfo traineeInfo) throws Exception {
		if (traineeInfo == null)
			throw new RemoteException("Job Applicant Info Can't be empty");
		if (traineeInfo.getName() == null)
			throw new RemoteException("name can't be empty");
		return traineeInfoRepository.save(traineeInfo);
	}

	@Override
	public List<TraineeInfo> listTraineeInfo() throws Exception {
		List<TraineeInfo> traineeInfoList = traineeInfoRepository.findAll();

		return traineeInfoList;
	}

	@Override
	public TraineeInfo getTraineeInfo(Long id) throws Exception {
		if (id == null)
			throw new RemoteException("id can't be empty");
		TraineeInfo traineeInfo = traineeInfoRepository.findById(id).get();

		return traineeInfo;
	}

	@Override
	public void deleteTraineeInfo(Long id) throws Exception {
		if (id == null)
			throw new RemoteException("id can't be empty");

		traineeInfoRepository.deleteById(id);

	}

	@Override
	public TraineeInfo getTraineeInfo(String email) throws Exception {
		if (email == null)
			throw new RemoteException("email can't be empty");

		return traineeInfoRepository.findByEmail(email).get(0);
	}

}
