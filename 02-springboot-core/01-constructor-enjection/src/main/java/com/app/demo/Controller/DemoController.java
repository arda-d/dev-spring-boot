package com.app.demo.Controller;

import com.app.demo.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //defining private field for dependency
    private final Coach myCoach;

    @Autowired
    public DemoController(Coach myCoach)
    {
        this.myCoach = myCoach;
    }

    @GetMapping("/getworkout")
    public String getDailyWorkout()
    {
        return this.myCoach.getDailyWorkout();
    }
}
