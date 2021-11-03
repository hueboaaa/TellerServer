package com.teller.tellerserver.service;

import com.teller.tellerserver.ApiParse;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    private final ApiParse apiParse;

    public LoginServiceImpl(ApiParse apiParse) {
        this.apiParse = apiParse;
    }

    @Override
    public String kakao(String code) {
        apiParse.kakaoUserInfo(code);

        return null;
    }
}
