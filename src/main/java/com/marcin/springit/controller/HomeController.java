package com.marcin.springit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request){
        model.addAttribute("masseage","Hello World");
        return "index";
    }

}
