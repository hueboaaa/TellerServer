package com.teller.tellerserver.service;

import com.teller.tellerserver.ApiParse;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Override
    public String kakao(String code) {
        ApiParse.kakao_login_connect(code);

        return null;
    }
}
