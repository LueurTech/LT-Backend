package com.LT.Form.service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.Form.entity.Domain;
import com.LT.Form.repository.DomainRepository;
import com.LT.Form.service.DomainService;

/**
 * Implementation class of Domain service
 * 
 * @author Mukund
 * @version 1.0
 *
 */

@Service
public class DomainServiceImpl implements DomainService {

    @Autowired
    private DomainRepository domainRepository;

    @Override
    public List<Domain> getAllDomains() throws Exception {
        List<Domain> domains = domainRepository.findAll();

        return domains;
    }

    @Override
    public Domain getDomainById(Long id) throws Exception {
        return domainRepository.findById(id).orElseThrow(() -> new Exception("ERROR NOT FOUND"));
    }

    @Override
    public Domain addDomain(Domain domain) throws Exception {
        if (domain == null)
            throw new RemoteException("Job Role cannot be empty");
        return domainRepository.save(domain);
    }

    @Override
    public Domain updateDomain(Domain domain) throws Exception {
        if (domain == null)
            throw new RemoteException("Job Role cannot be empty");
        return domainRepository.save(domain);
    }

}
