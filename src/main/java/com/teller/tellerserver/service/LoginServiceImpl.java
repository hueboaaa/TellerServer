package com.teller.tellerserver.service;

import com.teller.tellerserver.parse.KakaoParse;
import com.teller.tellerserver.ResponseDto;
import com.teller.tellerserver.dto.LoginDto;
import com.teller.tellerserver.parse.GoogleParse;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    private final KakaoParse kakaoParse;
    private final GoogleParse googleParse;

    public LoginServiceImpl(KakaoParse kakaoParse, GoogleParse googleParse) {
        this.kakaoParse = kakaoParse;
        this.googleParse = googleParse;
    }

    @Override
    public LoginDto kakao(String code) {
        LoginDto loginDto = kakaoParse.kakaoUserInfo(code);

        return loginDto;
    }

    @Override
    public ResponseDto google(String code) {
        ResponseDto googleResponseDto = googleParse.google_login_connect(code);
        return googleResponseDto;
    }
}
