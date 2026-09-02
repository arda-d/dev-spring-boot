package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    //define endpoint for "/students"

    @PostConstruct
    public void loadData(){
        this.students = new ArrayList<>();

        students = new ArrayList<>();
        students.add(new Student("Poornima","Patel"));
        students.add(new Student("Daniel","Clein"));
        students.add(new Student("Mario","Jackson"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Poornima","Patel"));
        students.add(new Student("Daniel","Clein"));
        students.add(new Student("Mario","Jackson"));
        return students;
    }

    //define endpoints of "/students/{studentId}"

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId){
        //check the studentId again list size
        if(studentId < 0 || studentId > students.size()){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }

}
