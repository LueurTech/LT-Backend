package com.LT.Form.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LT.Form.entity.InternCertificateDetails;

public interface InternCertificateRepository extends JpaRepository<InternCertificateDetails, Long>{

	InternCertificateDetails findByEmail(String email);

	InternCertificateDetails findByPhoneNo(String phoneNo);

}
