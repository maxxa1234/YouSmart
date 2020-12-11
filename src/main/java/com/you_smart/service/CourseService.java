package com.you_smart.service;

import com.you_smart.enteties.Course;
import com.you_smart.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CourseService {


    private CourseRepository courseRepository;
    private UserService userService;

    @Autowired
    public CourseService(CourseRepository courseRepository, UserService userService) {
        this.courseRepository = courseRepository;
        this.userService = userService;
    }

    public void addNewCourse(Course course){
        course.setUser(userService.getCurrentUser());
        courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id){
        return courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Course with "+ id +" does not exists"));
    }

    public void addStudentToCourse(Course course){
        course.setStudents(userService.getCurrentUser());
        courseRepository.save(course);
    }

}
