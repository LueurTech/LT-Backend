package com.LT.Form.service;

import java.util.List;

import com.LT.Form.entity.TrainerDocument;

/**
 * Shows the list of services provided in Trainer Document management
 * 
 * @author Mukund
 * @version 1.0
 *
 */


public interface TrainerDocumentService {

	 List<TrainerDocument> getTrainerDocumentsByTrainerId(Long trainerId) throws Exception;

	 TrainerDocument getDocument(String fileId) throws Exception;
	
}
