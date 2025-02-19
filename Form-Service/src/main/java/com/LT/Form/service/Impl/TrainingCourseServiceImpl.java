package com.LT.Form.service.Impl;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LT.Form.entity.TrainingCourse;
import com.LT.Form.repository.TrainingCourseRepository;
import com.LT.Form.service.TrainingCourseService;

/**
 * Implementation class of TrainingCourse service
 * 
 * @author Dhruvil
 * @version 1.0
 *
 */

@Service
public class TrainingCourseServiceImpl implements TrainingCourseService {

    @Autowired
    private TrainingCourseRepository trainingCourseRepository;

    @Override
    public List<TrainingCourse> getAllTrainingCourses() throws Exception {
        List<TrainingCourse> trainingCourses = trainingCourseRepository.findAll();

        return trainingCourses;
    }

    @Override
    public TrainingCourse getTrainingCourseById(Long id) throws Exception {
        return trainingCourseRepository.findById(id).orElseThrow(() -> new Exception("ERROR NOT FOUND"));
    }

    @Override
    public TrainingCourse addTrainingCourse(TrainingCourse trainingCourse) throws Exception {
        if (trainingCourse == null)
            throw new RemoteException("Job Role cannot be empty");
        return trainingCourseRepository.save(trainingCourse);
    }

    @Override
    public TrainingCourse updateTrainingCourse(TrainingCourse trainingCourse) throws Exception {
        if (trainingCourse == null)
            throw new RemoteException("Job Role cannot be empty");
        return trainingCourseRepository.save(trainingCourse);
    }

}
