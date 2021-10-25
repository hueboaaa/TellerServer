package com.teller.tellerserver.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String user_email;
    private String user_name;
    private String user_gender;
    private String user_birthday;
    private String user_password;
    private LocalDateTime user_joindate;
    private String user_is_del;
    private LocalDateTime user_del_date;
    private String user_device;
    private String user_is_proud;
    private String user_social_path;
}
