package com.LT.Form.service;

import java.util.List;

import com.LT.Form.entity.TrainingCourse;

/**
 * Shows the list of services provided in TrainingCourse management
 * 
 * @author Dhruvil
 * @version 1.0
 *
 */

public interface TrainingCourseService {

    TrainingCourse getTrainingCourseById(Long id) throws Exception;

    List<TrainingCourse> getAllTrainingCourses() throws Exception;

    TrainingCourse addTrainingCourse(TrainingCourse trainingCourse) throws Exception;

    TrainingCourse updateTrainingCourse(TrainingCourse trainingCourse) throws Exception;
}
