package com.harris.springsecuritydemo.controller.DemoController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/getUsers")
    public List<DemoUser> getUsers(){
        return Arrays.asList(new DemoUser("Harris", 986653727), new DemoUser("Shahil", 74637284));
    }
}
