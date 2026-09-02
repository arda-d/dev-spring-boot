package com.app.demo.controller;

import com.app.demo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {
        //create a new student object
        Student student = new Student();
        //add student object as a model attribute
        model.addAttribute("student", student);
        //add the list of countries
        model.addAttribute("countries", countries);
        return "student-form";
    }

    @PostMapping("/postStudentForm")
    public String postForm(@ModelAttribute("student") Student student) {
        //log in the data

        System.out.println("theStudent: " + student.toString());

        return "student-confirm";
    }
}
