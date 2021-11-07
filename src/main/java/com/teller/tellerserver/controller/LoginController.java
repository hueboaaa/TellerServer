package com.teller.tellerserver.controller;

import com.teller.tellerserver.dto.LoginDto;
import com.teller.tellerserver.service.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {


    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/kakao")
    public LoginDto kakaoLogin(@RequestParam("code") String code){
        System.out.println("code = " + code);
        LoginDto kakao = loginService.kakao(code);
        return kakao;
    }

//    public String naverLogin(@RequestParam)

}
