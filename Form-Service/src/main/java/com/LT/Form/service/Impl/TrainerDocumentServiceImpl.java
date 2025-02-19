package com.LT.Form.service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.Form.entity.TrainerDocument;
import com.LT.Form.repository.TrainerDocumentRepository;
import com.LT.Form.service.TrainerDocumentService;

/**
 * Implementation class of Trainer Document service Implementation
 * 
 * @author Mukund
 * @version 1.0
 *
 */

@Service
public class TrainerDocumentServiceImpl implements TrainerDocumentService {

	@Autowired
	TrainerDocumentRepository trainerDocumentRepository;

	@Override
	public List<TrainerDocument> getTrainerDocumentsByTrainerId(Long trainerId) throws Exception {
		if (trainerId == null) {
			throw new RemoteException("TrainerId can't be empty");
		}
		return trainerDocumentRepository.findByTrainerInfoId(trainerId);
	}

	@Override
	public TrainerDocument getDocument(String fileId) throws Exception {
		return trainerDocumentRepository.findById(fileId).orElseThrow(() -> new Exception("ERROR NOT FOUND"));
	}

}
