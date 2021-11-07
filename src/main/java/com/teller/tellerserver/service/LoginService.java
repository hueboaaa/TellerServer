package com.teller.tellerserver.service;

import com.teller.tellerserver.dto.LoginDto;

public interface LoginService {

    public LoginDto kakao(String code);
}
