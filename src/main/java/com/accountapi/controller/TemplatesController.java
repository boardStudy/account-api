package com.accountapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplatesController {

    @GetMapping("/users/login")
    public String loadLoginPage() {
        return "login";
    }

//    @GetMapping("/users/login-test")
//    public String test() {
//        return "list";
//    }
}
