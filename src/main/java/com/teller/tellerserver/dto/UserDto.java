package com.teller.tellerserver.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {

    private String user_email;
    private String user_name;
    private String user_gender;
    private String user_birthday;
    private String user_password;
    private String check_password;
    private String user_device;
    private String user_is_proud;
    private String user_social_path;
}
