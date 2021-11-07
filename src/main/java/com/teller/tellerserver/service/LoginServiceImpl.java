package com.teller.tellerserver.service;

import com.teller.tellerserver.ApiParse;
import com.teller.tellerserver.dto.LoginDto;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    private final ApiParse apiParse;

    public LoginServiceImpl(ApiParse apiParse) {
        this.apiParse = apiParse;
    }

    @Override
    public LoginDto kakao(String code) {
        LoginDto loginDto = apiParse.kakaoUserInfo(code);

        return loginDto;
    }
}
