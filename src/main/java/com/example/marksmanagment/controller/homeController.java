package com.example.marksmanagment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class homeController {

@GetMapping("/")
    public String home(){
    return "home";
}

@GetMapping("/student_OP")
    public String studentOP(){
    return "student_OP";
    }

    @GetMapping("/marks_OP")
    public String marksOP(){
      return "marks_OP";
    }



}
