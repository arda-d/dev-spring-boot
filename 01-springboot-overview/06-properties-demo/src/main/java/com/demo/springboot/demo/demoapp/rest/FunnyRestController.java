package com.demo.springboot.demo.demoapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunnyRestController {
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + ", Team: " + teamName;
    }
    //expose "/" that returns "Hello World!"
    @GetMapping("/")
    public String sayHello()
    {
        return "Hello World!";
    }

    //expose a new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorkout()
    {
        return "Run a hard new 5k!";
    }

    //expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getFortune()
    {
        return "Today is your lucky day, actually, any day is your lucky day!";
    }
}
