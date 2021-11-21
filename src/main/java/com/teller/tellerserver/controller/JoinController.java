package com.teller.tellerserver.controller;

import com.teller.tellerserver.dto.UserDto;
import com.teller.tellerserver.repository.UserRepository;
import com.teller.tellerserver.service.JoinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }


    @PostMapping("/join")
    public void user_join(@RequestBody UserDto userDto){

        joinService.user_join(userDto);
    }


}
