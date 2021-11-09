package com.teller.tellerserver.dto;

import com.teller.tellerserver.ResponseDto;
import com.teller.tellerserver.domain.SocialPath;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LoginDto {

    private String id;
    private String email;
    private String nickname;
    private SocialPath social_path;

    public LoginDto(String id, String email, String nickname, SocialPath social_path) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.social_path = social_path;
    }
}
