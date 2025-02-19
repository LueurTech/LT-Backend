package com.LT.Form.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.LT.Form.dto.InternCertificateResponse;
import com.LT.Form.entity.InternCertificateDetails;

/**
 * 
 * @author Mukund
 * @version 1.0
 */

@Mapper(componentModel = "spring")
public interface InternCertificateMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phoneNo", target = "phoneNo")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "dob", target = "dob")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "degree", target = "degree")
    @Mapping(source = "branch", target = "branch")
    @Mapping(source = "yop", target = "yop")
    @Mapping(source = "cgpa", target = "cgpa")
    @Mapping(source = "college_Name", target = "college_Name")
    @Mapping(source = "yop_12", target = "yop_12")
    @Mapping(source = "percentage_12", target = "percentage_12")
    @Mapping(source = "college_12", target = "college_12")
    @Mapping(source = "yop_10", target = "yop_10")
    @Mapping(source = "percentage_10", target = "percentage_10")
    @Mapping(source = "school_10", target = "school_10")
    @Mapping(source = "active_Backlog", target = "active_Backlog")
    @Mapping(source = "timestamp", target = "timestamp")
    // @Mapping(source = "selectedDomain", target = "selectedDomain")
    @Mapping(source = "duration", target = "duration")
    InternCertificateResponse mapInternCertificateDetailsToInternCertificateResponse(
            InternCertificateDetails internCertificateDetails);

}
