package com.accountapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplatesController {

    // 로그인 페이지
    @GetMapping("/users/login")
    public String loadLoginPage() {
        return "login";
    }

    // 회원가입 페이지
    @GetMapping("/users/sign-up")
    public String loadSignUpForm() {
        return "signUp";
    }
}
