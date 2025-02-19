package com.LT.Form.service;

import java.util.List;

import com.LT.Form.entity.InternDocument;

/**
 * Shows the list of services provided in InternDocument management
 * 
 * @author Dhruvil
 * @version 1.0
 *
 */

public interface InternDocumentService {

    List<InternDocument> getInternDocumentsByInternId(Long internId) throws Exception;

    InternDocument getDocument(String fileId) throws Exception;
}
