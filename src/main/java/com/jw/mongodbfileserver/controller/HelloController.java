package com.jw.mongodbfileserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * a hello world test.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }
}
