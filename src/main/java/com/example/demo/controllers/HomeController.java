package com.example.demo.controllers;

import com.example.demo.Repository.UserRepository;
import com.example.demo.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;
    @GetMapping(value = "/")
    public String home()
    {
        return "index";
    }

    @GetMapping(value = "/contact")
    public String contactGet(WebRequest request, Model model)
    {
        Contact contact = new Contact();
        model.addAttribute("contact",contact);
        return "contact";
    }

    @GetMapping(value = "/about")
    public String about()
    {
        return "about";
    }

    @PostMapping(value = "/contact")
    public String contactSubmit(@ModelAttribute("contact") Contact contact)
    {
        userRepository.save(contact);
        return "contact";
    }
}
