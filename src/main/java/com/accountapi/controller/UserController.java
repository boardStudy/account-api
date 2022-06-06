package com.accountapi.controller;

import com.accountapi.dto.LoginRequest;
import com.accountapi.dto.User;
import com.accountapi.service.AccountManager;
import com.accountapi.service.ValidationManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final AccountManager accountManager;
    private final ValidationManager validationManager;

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<Void> login(LoginRequest loginRequest, HttpSession session) {

        User user = accountManager.findUserById(loginRequest.getUserId());
        if (user == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        String rawPassword = loginRequest.getPassword();
        String encodedPassword = user.getPassword();

        if (validationManager.validateByPassword(rawPassword, encodedPassword)) {
            session.setAttribute("user", user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // 로그아웃
    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    // 회원가입

    // 회원 수정


}
