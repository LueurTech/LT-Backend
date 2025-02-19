package com.LT.Form.service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.Form.entity.TrainerInfo;
import com.LT.Form.repository.TrainerInfoRepository;
import com.LT.Form.service.TrainerInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementation class of TrainerInfo service Implementation
 * 
 * @author Mukund
 * @version 1.0
 *
 */
@Slf4j
@Service
public class TrainerInfoServiceImpl implements TrainerInfoService {

	@Autowired
	TrainerInfoRepository trainerInfoRepository;

	@Override
	public TrainerInfo addTrainerInfo(TrainerInfo trainerInfo) throws Exception {
		if (trainerInfo == null)
			throw new RemoteException("Trainer Applicant Info Can't be empty");
		if (trainerInfo.getName() == null)
			throw new RemoteException("name can't be empty");
		return trainerInfoRepository.save(trainerInfo);
	}

	@Override
	public TrainerInfo updateTrainerInfo(TrainerInfo trainerInfo) throws Exception {
		if (trainerInfo == null)
			throw new RemoteException("Job Applicant Info Can't be empty");
		if (trainerInfo.getName() == null)
			throw new RemoteException("name can't be empty");
		return trainerInfoRepository.save(trainerInfo);
	}

	@Override
	public List<TrainerInfo> listTrainerInfo() throws Exception {
		List<TrainerInfo> trainerInfoList = trainerInfoRepository.findAll();

		return trainerInfoList;
	}

	@Override
	public TrainerInfo getTrainerInfo(Long id) throws Exception {
		if (id == null)
			throw new RemoteException("id can't be empty");
		TrainerInfo trainerInfo = trainerInfoRepository.findById(id).get();

		return trainerInfo;
	}

	@Override
	public void deleteTrainerInfo(Long id) throws Exception {
		if (id == null)
			throw new RemoteException("id can't be empty");

		trainerInfoRepository.deleteById(id);

	}

}
