package com.LT.Form.service;

import java.util.List;

import com.LT.Form.entity.TraineeDocument;

/**
 * Shows the list of services provided in TraineeDocument management
 * 
 * @author Dhruvil
 * @version 1.0
 *
 */

public interface TraineeDocumentService {

    List<TraineeDocument> getTraineeDocumentsByTraineeId(Long traineeId) throws Exception;

    TraineeDocument getDocument(String fileId) throws Exception;
}
