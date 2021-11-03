package com.teller.tellerserver.dto.Kakao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KaKaoDto {

    private String access_token;
    private String token_type;
    private String refresh_token;
    private String expires_in;
    private String scope;
    private String refresh_token_expires_in;

}
