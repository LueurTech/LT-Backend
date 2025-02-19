package com.LT.Form.mapper;

import org.mapstruct.Mapping;

import com.LT.Form.dto.TraineeInfoResponse;
import com.LT.Form.entity.TraineeInfo;

/**
 * 
 * @author Mukund
 * @version 1.0
 */
public interface TraineeInfoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phoneNo", target = "phoneNo")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "dob", target = "dob")

    @Mapping(source = "address", target = "address")
    @Mapping(source = "state", target = "state")
    @Mapping(source = "landmark", target = "landmark")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "pinCode", target = "pinCode")

    @Mapping(source = "degree", target = "degree")
    @Mapping(source = "branch", target = "branch")
    @Mapping(source = "yop", target = "yop")
    @Mapping(source = "cgpa", target = "cgpa")
    @Mapping(source = "collegeName", target = "collegeName")

    @Mapping(source = "skills", target = "skills")
    @Mapping(source = "duration", target = "duration")

    @Mapping(source = "timestamp", target = "timestamp")
    TraineeInfoResponse mapTraineeInfoToTraineeInfoResponse(TraineeInfo traineeInfo);
}
