package com.LT.Form.service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.Form.entity.TraineeDocument;
import com.LT.Form.repository.TraineeDocumentRepository;
import com.LT.Form.service.TraineeDocumentService;

/**
 * Implementation class of TraineeDocument service Impl
 * 
 * @author Mukund
 * @version 1.0
 *
 */

@Service
public class TraineeDocumentServiceImpl implements TraineeDocumentService {

    @Autowired
    TraineeDocumentRepository traineeDocumentRepository;

    @Override
    public List<TraineeDocument> getTraineeDocumentsByTraineeId(Long traineeId) throws Exception {
        if (traineeId == null) {
            throw new RemoteException("applicantId can't be empty");
        }
        return traineeDocumentRepository.findByTraineeInfoId(traineeId);
    }

    @Override
    public TraineeDocument getDocument(String fileId) throws Exception {
        return traineeDocumentRepository.findById(fileId).orElseThrow(() -> new Exception("ERROR NOT FOUND"));
    }

}
