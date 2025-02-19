package com.LT.Form.service;

import java.util.List;

import com.LT.Form.entity.Domain;

/**
 * Shows the list of services provided in Domain management
 * 
 * @author Mukund
 * @version 1.0
 *
 */

public interface DomainService {

    Domain getDomainById(Long id) throws Exception;

    List<Domain> getAllDomains() throws Exception;

    Domain addDomain(Domain domain) throws Exception;

    Domain updateDomain(Domain domain) throws Exception;
}
