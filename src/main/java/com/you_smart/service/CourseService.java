package com.you_smart.service;

import com.you_smart.enteties.Course;
import com.you_smart.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserService userService;

    public void addNewCourse(Course course,String email){
        course.setUser(userService.currentUser(email));
        courseRepository.save(course);
    }
}
