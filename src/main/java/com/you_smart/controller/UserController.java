package com.you_smart.controller;

import com.you_smart.enteties.Course;
import com.you_smart.enteties.User;
import com.you_smart.exception.UserServiceException;
import com.you_smart.service.CourseService;
import com.you_smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;
    private CourseService courseService;

    @Autowired
    public UserController(UserService userService, CourseService courseService) {
        this.userService = userService;
        this.courseService = courseService;
    }

    @GetMapping("/registration")
    public ModelAndView registration(){
        return new ModelAndView("registration", "user", new User());
    }

    @PostMapping("/registration")
    public ModelAndView addNewUser(User user, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView;
        try {
            userService.addNewUser(user);
        } catch (UserServiceException e){
            modelAndView = new ModelAndView("redirect:/registration");
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return  modelAndView;
        }

        return modelAndView = new ModelAndView("redirect:/login");
    }

    @GetMapping("/profile")
    public ModelAndView profile(){
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("user", userService.getCurrentUser());
        modelAndView.addObject("courses", userService.getCurrentUser().getCourses());
        modelAndView.addObject("studentsCourses",userService.getCurrentUser().getCoursesForStudents());
        return modelAndView;
    }

}
