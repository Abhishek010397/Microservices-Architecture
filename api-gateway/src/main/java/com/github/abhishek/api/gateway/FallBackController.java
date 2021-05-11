package com.github.abhishek.api.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    //create the methods
    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "User Service Not Available";
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod(){
        return "Department Service Not Available";
    }
}
