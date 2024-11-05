package com.example.crud_ods.controller;

import com.example.crud_ods.domain.User;
import com.example.crud_ods.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping
    public String helloWorld(){
        return helloWorldService.helloWorld("EGMJ");
    }

    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable("id") String id, @RequestBody User body){
        return "Hello World post" + body.getName() + " " + id;
    }
}
