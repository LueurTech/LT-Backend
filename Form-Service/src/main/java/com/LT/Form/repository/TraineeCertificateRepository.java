package com.LT.Form.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LT.Form.entity.TraineeCertificateDetails;

public interface TraineeCertificateRepository extends JpaRepository<TraineeCertificateDetails, Long> {

    TraineeCertificateDetails findByEmail(String email);

    TraineeCertificateDetails findByPhoneNo(String phoneNo);

}
