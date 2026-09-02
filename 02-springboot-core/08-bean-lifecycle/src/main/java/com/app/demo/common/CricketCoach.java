package com.app.demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.beans.BeanProperty;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!..";
    }

    @PostConstruct
    public void init() {
        System.out.println("In postConstruct: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("In preDestroy: " + getClass().getSimpleName());
    }
}
