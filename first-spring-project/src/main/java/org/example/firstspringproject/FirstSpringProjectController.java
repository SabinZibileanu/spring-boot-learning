package org.example.firstspringproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FirstSpringProjectController {
    @RequestMapping
    public String obtain_string() {
        return "Hello World";
    }
}
