package com.accountapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class TemplatesController {

    @GetMapping("/login")
    public String loadLoginPage(){
        return "login";
    }
}
