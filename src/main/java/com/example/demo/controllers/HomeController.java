package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String home()
    {
        return "contact";
    }

    @GetMapping(value = "/contact")
    public String contact()
    {
        return "contact";
    }

    @GetMapping(value = "/about")
    public String about()
    {
        return "about";
    }

    @PostMapping(value = "/contact")
    public String contactSubmit(@ModelAttribute Contact contact)
    {
        return ""
    }
}
