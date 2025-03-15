package org.example.learningprojectspring.controllers;

import org.example.learningprojectspring.services.MovieReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {
    @Autowired
    private MovieReaderService movieReaderService;

    @GetMapping("/req/login")
    public String login() {
        return "login";
    }

    @GetMapping("/req/register")
    public String register() {
        return "register";
    }

    @GetMapping("/index")
    public String home() {
        movieReaderService.readMovieData();
        return "index";
    }
}
