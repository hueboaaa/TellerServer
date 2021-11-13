package com.teller.tellerserver.dto.Google;

import com.teller.tellerserver.ResponseDto;
import lombok.Data;

@Data
public class GoogleUserInfo extends ResponseDto {

    private String iss;
    private String azp;
    private String aud;
    private String sub;
    private String at_hash;
    private String name;
    private String picture;
    private String given_name;
    private String family_name;
    private String locale;
    private String iat;
    private String exp;
    private String alg;
    private String kid;
    private String typ;
}
