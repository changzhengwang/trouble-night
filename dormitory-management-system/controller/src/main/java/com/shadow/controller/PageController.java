package com.shadow.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/hello")
    public String openHelloPage(){
        return "hello";
    }
}
