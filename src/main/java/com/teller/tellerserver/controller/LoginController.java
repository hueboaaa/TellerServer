package com.teller.tellerserver.controller;

import com.teller.tellerserver.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    @GetMapping("/kakao")
    public String kakaoLogin(@RequestParam("code") String code){
        System.out.println("code = " + code);
        loginService.kakao(code);
        return null;
    }

}
