package com.LT.Form.service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.Form.entity.InternDocument;
import com.LT.Form.repository.InternDocumentRepository;
import com.LT.Form.service.InternDocumentService;

/**
 * Implementation class of InternDocument service Impl
 * 
 * @author Mukund
 * @version 1.0
 *
 */

@Service
public class InternDocumentServiceImpl implements InternDocumentService {

    @Autowired
    InternDocumentRepository internDocumentRepository;

    @Override
    public List<InternDocument> getInternDocumentsByInternId(Long internId) throws Exception {
        if (internId == null) {
            throw new RemoteException("applicantId can't be empty");
        }
        return internDocumentRepository.findByInternInfoId(internId);
    }

    @Override
    public InternDocument getDocument(String fileId) throws Exception {
        return internDocumentRepository.findById(fileId).orElseThrow(() -> new Exception("ERROR NOT FOUND"));
    }

}
