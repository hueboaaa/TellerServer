package com.teller.tellerserver.controller;

import com.teller.tellerserver.ResponseDto;
import com.teller.tellerserver.dto.Google.GoogleResponseDto;
import com.teller.tellerserver.dto.LoginDto;
import com.teller.tellerserver.service.LoginService;
import org.springframework.http.ResponseEntity;
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
        System.out.println("kakao.toString() = " + kakao.toString());
        return kakao;
    }

    @GetMapping("/googleLogin")
    public ResponseEntity<ResponseDto> googleLogin(@RequestParam("code") String code){
        System.out.println("code = " + code);

            ResponseDto google = loginService.google(code);


        return ResponseEntity.ok(google);
    }




}
