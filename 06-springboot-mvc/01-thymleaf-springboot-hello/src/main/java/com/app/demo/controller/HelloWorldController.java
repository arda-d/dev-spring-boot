package com.app.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //Request mapping for "/showForm"
    @RequestMapping("/showForm")
    public String showForm() {

        return "helloworld-form";
    }

    //Request mapping for "/postForm"
    @RequestMapping("/postForm")
    public String postForm() {

        return "helloworld";
    }

    //Create a class to request mapping "/postFormVersionTwo"
    @RequestMapping("/postFormVersionTwo")
    public String shoutDude(HttpServletRequest request, Model model) {
        //Read from HTML
        String name = request.getParameter("studentName");
        //Convert to all caps
        name = name.toUpperCase();
        //Generating the message
        String result = "Yo! " + name;
        //Adding the message into model
        model.addAttribute("message", result);
        return "helloworld";
    }

    //Create a class to request mapping "/postFormVersionThree"
    @RequestMapping("/postFormVersionThree")
    public String shoutsDude(@RequestParam("studentName") String name, Model model) {
        //Read from HTML
        //Since we used @RequestParam("studentName"), the program already put the parameter into the name string
        //Convert to all caps
        name = name.toUpperCase();
        //Generating the message
        String result = "Hey! " + name;
        //Adding the message into model
        model.addAttribute("message", result);
        return "helloworld";
    }
}
