package com.accountapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank(message = "아이디는 필수 입력값 입니다.")
    @Pattern(regexp = "^([a-z0-9]){4,30}$", message = "아이디를 확인해주세요.")
    private String userId;
    @NotBlank(message = "비밀번호는 필수 입력값 입니다.")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}", message = "비밀번호를 확인해주세요.")
    private String password;
}
