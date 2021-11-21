package com.teller.tellerserver.service;

import com.teller.tellerserver.domain.SocialPath;
import com.teller.tellerserver.domain.User;
import com.teller.tellerserver.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;
import java.util.Optional;


@SpringBootTest
class JoinServiceTest {

    @Autowired
    UserRepository userRepository;

    @DisplayName("회원가입")
    @Test
    void 회원가입(){
        //given
        User user = new User();
        user.setUser_email("kiaofk@naver.com");
        user.setUser_name("서상원");
        user.setUser_gender("M");
        user.setSocialPath(SocialPath.KAKAO);
        user.setUser_device("아이폰13");
        user.setUser_joindate(LocalDateTime.now());
        user.setUser_birthday("19940309");

        //when
        User joinM = userRepository.save(user);
        User byId = userRepository.getById(joinM.getId());

        //then
        Assertions.assertThat(joinM.getId()).isEqualTo(byId.getId());

    }

}