package com.accountapi.controller;

import com.accountapi.dto.LoginRequest;
import com.accountapi.dto.User;
import com.accountapi.service.AccountManager;
import com.accountapi.service.DuplicateChecker;
import com.accountapi.service.ValidationManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final AccountManager accountManager;
    private final ValidationManager validationManager;
    private final DuplicateChecker duplicateChecker;

    private static final String MAIN_PAGE_URL = "/board/list";

    // 로그인
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest, HttpSession session) {

        User user = accountManager.findUserById(loginRequest.getUserId());

        // 아이디 확인
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        // 비밀번호 확인
        String rawPassword = loginRequest.getPassword();
        String encodedPassword = user.getPassword();
        if (!validationManager.validateByPassword(rawPassword, encodedPassword)) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        // 로그인 성공
        session.setAttribute("user", user.getUserId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 로그아웃
    @GetMapping("/logout")
    public void logout(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String domain = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        session.invalidate();
        response.sendRedirect(domain + MAIN_PAGE_URL);
    }

    // 회원가입
    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid User signUpInfo) {

        accountManager.createUser(signUpInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // ID 중복 확인
    @PostMapping("check/id")
    public int checkId(@RequestParam String userId) {
        int count = duplicateChecker.checkDuplicateId(userId);
        return count;
    }

    // 전화번호 중복 확인
    @PostMapping("check/phone")
    public int checkPhone(@RequestParam String phone) {
        int count = duplicateChecker.checkDuplicatePhone(phone);
        return count;
    }

}
