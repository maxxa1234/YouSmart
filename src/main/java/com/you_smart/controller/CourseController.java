package com.you_smart.controller;

import com.you_smart.enteties.Course;
import com.you_smart.enteties.User;
import com.you_smart.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courseCreation")
    public ModelAndView course(){
        return new ModelAndView("courseCreation", "course", new Course());
    }

    @PostMapping("/courseCreation")
    public ModelAndView addCourse(Course course){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        courseService.addNewCourse(course,name);
        return new ModelAndView("redirect:/index");
    }
}
