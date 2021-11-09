package com.teller.tellerserver.dto.Google;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoogleRequestDto {

    private String client_id;
    private String redirect_uri;
    private String clientSecret;
    private String code;
    private String response_type;
    private String scope;
    private String access_type;
    private String grantType;
    private String state;
    private String include_granted_scopes;
    private String login_hint;
    private String prompt;
}
