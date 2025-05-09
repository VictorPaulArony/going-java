package com.exchange.demo.controller;

//class with a method to display index.html file
import org.springframework.stereotype.Controller;

@Controller
public class HelloWorld {

    public String helloWorld(){
        return "index";
    }
    
}
