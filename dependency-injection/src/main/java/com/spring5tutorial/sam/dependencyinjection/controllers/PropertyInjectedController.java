package com.spring5tutorial.sam.dependencyinjection.controllers;

import com.spring5tutorial.sam.dependencyinjection.services.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
