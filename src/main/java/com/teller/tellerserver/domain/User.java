package com.teller.tellerserver.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String user_email;
    private String user_name;
    private String user_gender;
    private String user_birthday;
    private LocalDateTime user_joindate;
    private String user_is_del;
    private LocalDateTime user_del_date;
    private String user_device;
    @Enumerated(EnumType.STRING)
    private SocialPath socialPath;

    public User(){

    }


    public User(Long id, String user_email, String user_name, String user_gender, String user_birthday, LocalDateTime user_joindate, String user_is_del, LocalDateTime user_del_date, String user_device,  SocialPath socialPath) {
        this.id = id;
        this.user_email = user_email;
        this.user_name = user_name;
        this.user_gender = user_gender;
        this.user_birthday = user_birthday;
        this.user_joindate = user_joindate;
        this.user_is_del = user_is_del;
        this.user_del_date = user_del_date;
        this.user_device = user_device;
        this.socialPath = socialPath;
    }
}
