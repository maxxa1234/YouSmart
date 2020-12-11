package com.you_smart.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.you_smart.enteties.Course;
import com.you_smart.service.CourseService;
import com.you_smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    private UserService userService;
    private CourseService courseService;

    @Autowired
    public IndexController(UserService userService, CourseService courseService) {
        this.userService = userService;
        this.courseService = courseService;
    }

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", userService.getCurrentUser());
        modelAndView.addObject("getUserRole", userService.getCurrentUser().getRole());
        modelAndView.addObject("courses", courseService.getAllCourses());
        return modelAndView;
    }

    @PostMapping("/index")
    public ModelAndView addStudentToCourse(@RequestParam ("id") Long id){
        courseService.addStudentToCourse(courseService.getCourseById(id));
        return new ModelAndView("redirect:/profile");
    }

}
