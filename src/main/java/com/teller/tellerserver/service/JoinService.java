package com.teller.tellerserver.service;

import com.teller.tellerserver.domain.SocialPath;
import com.teller.tellerserver.domain.User;
import com.teller.tellerserver.dto.UserDto;
import com.teller.tellerserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;

    @Transactional
    public void user_join(UserDto userDto){
        User user = new User();
        user.setUser_email(userDto.getUser_email());
        user.setUser_birthday(userDto.getUser_birthday());
        user.setUser_gender(userDto.getUser_gender());
        user.setUser_joindate(LocalDateTime.now());
        user.setUser_name(userDto.getUser_name());
        user.setUser_device(userDto.getUser_device());
        user.setSocialPath(SocialPath.KAKAO);
        userRepository.save(user);
    }
}
