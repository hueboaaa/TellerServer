package com.teller.tellerserver.service;

import com.teller.tellerserver.ResponseDto;
import com.teller.tellerserver.dto.Google.GoogleResponseDto;
import com.teller.tellerserver.dto.LoginDto;

public interface LoginService {

    public LoginDto kakao(String code);

    public ResponseDto google(String code);
}
