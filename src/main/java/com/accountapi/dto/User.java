package com.accountapi.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(min = 4, max = 30, message = "아이디는 4글자에서 30글자 사이로 입력해주세요.")
    @Pattern(regexp = "^([a-z가-힣0-9]){4,30}$", message = "대문자, 특수문자는 입력할 수 없습니다.")
    private String userId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, max = 20, message = "최소 8자에서 최대 20자까지 입력 가능합니다.")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}", message = "영문, 숫자, 특수문자가 적어도 1개 이상 조합되게 입력해주세요.")
    private String password;

    @Email(message = "이메일 형식에 맞게 입력해주세요.")
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "전화번호를 입력해주세요.")
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "전화번호 형식에 맞게 입력해주세요.")
    private String phone;

    private LocalDateTime regDate;
    private LocalDateTime updDate;
    private LocalDateTime withdDate;
    private int withdStatus;
    private int gender;
    private int userAuth;

    public User(String userId, String password, String email, String name, int gender, String phone) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.regDate = LocalDateTime.now();
    }

}
