package com.LT.Form.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LT.Form.entity.Domain;

/**
 * Repository for managing the Domain data
 * 
 * @author Mukund
 * @version 1.0
 *
 */

public interface DomainRepository extends JpaRepository<Domain, Long> {

}
