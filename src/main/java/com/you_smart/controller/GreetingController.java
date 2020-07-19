package com.you_smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {


    @GetMapping("/greeting")
    public ModelAndView greeting(){
        ModelAndView modelAndView = new ModelAndView("greeting");
        modelAndView.addObject("name", "name");
        return modelAndView;
    }
}
