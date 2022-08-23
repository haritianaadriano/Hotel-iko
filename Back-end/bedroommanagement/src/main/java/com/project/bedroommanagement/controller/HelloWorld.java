package com.project.bedroommanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloWorld {
    @GetMapping("/")
    public String helloWorld(){
        return "hello world, congratulation spring work";
    }
}
