package com.example.demo.controllers;

import com.example.demo.DAO.UserDao;
import com.example.demo.Exceptions.EmailExistsException;
import com.example.demo.Repository.ContactRepository;
import com.example.demo.Service.UserService;
import com.example.demo.models.Contact;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    UserService service;

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

    @GetMapping(value = "/register")
    public String register(Model model)
    {
        UserDao user = new UserDao();
        model.addAttribute("user",user);
        return "register";
    }

    @PostMapping(value = "/contact")
    public String contactSubmit(@ModelAttribute("contact") Contact contact)
    {
        contactRepository.save(contact);
        return "contact";
    }

    @PostMapping(value = "/register")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDao accountDto,
            BindingResult result, WebRequest request, Errors errors) {
            User registered = new User();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            return new ModelAndView("register", "user", accountDto);
        }
        else {
            return new ModelAndView("successRegister", "user", accountDto);
        }
    }

    private User createUserAccount(UserDao accountDto, BindingResult result) {
        User registered = null;
        try {
            registered = service.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }
}
