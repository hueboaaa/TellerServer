package com.teller.tellerserver.dto.Google;

import com.teller.tellerserver.ResponseDto;
import lombok.Data;

@Data
public class GoogleResponseDto extends ResponseDto {

    private String id_token;
    private String access_token;
    private String expires_in;
    private String refresh_token;
    private String scope;
    private String token_type;
}
