package com.example.crud_ods.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public String helloWorld(String name){
        return "Hello world " + name;
    }

}
