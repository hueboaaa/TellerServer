package com.teller.tellerserver.parse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teller.tellerserver.ResponseDto;
import com.teller.tellerserver.domain.SocialPath;
import com.teller.tellerserver.dto.Google.GoogleRequestDto;
import com.teller.tellerserver.dto.Google.GoogleResponseDto;
import com.teller.tellerserver.dto.Kakao.KaKaoDto;
import com.teller.tellerserver.dto.Kakao.KaKaoUserInfo;
import com.teller.tellerserver.dto.LoginDto;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class KakaoParse {

    private static final String KAKAO_REQUEST_URL =
            "https://kauth.kakao.com/oauth/token";

    private static final String KAKAO_REQUEST_USERINFO = "https://kapi.kakao.com/v2/user/me";


    public String kakao_login_connect(String code){

        //Http 헤더에 JSON 정보를 넣어줌
        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        httpHeaders.add("Content-Type", "application/x-www-form-urlencoded");

        //Body에 정보를 담아서 넘기기위해 정보 담음
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "d668bc37f8cdcbd66a0dc039ba553dac");
        params.add("redirect_uri", "http://localhost:8083/kakao");
        params.add("code", code);


        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(params, httpHeaders);

        ResponseEntity<String> token = restTemplate.exchange(KAKAO_REQUEST_URL, HttpMethod.POST, entity, String.class);

        System.out.println("token = " + token);

        ObjectMapper obj = new ObjectMapper();
        try{
            KaKaoDto kaKaoDto = obj.readValue(token.getBody(), KaKaoDto.class);
            System.out.println("kaKaoDto.getAccess_token() = " + kaKaoDto.getAccess_token());
            System.out.println("kaKaoDto = " + kaKaoDto);
            return kaKaoDto.getAccess_token();
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public LoginDto kakaoUserInfo(String code){
        String Access_token = this.kakao_login_connect(code);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + Access_token);

        HttpEntity<MultiValueMap<String,String>> kakao = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> user = restTemplate.exchange(KAKAO_REQUEST_USERINFO, HttpMethod.POST, kakao, String.class);
        System.out.println("user = " + user);

        ObjectMapper obj = new ObjectMapper();

        try{
            KaKaoUserInfo kaUserInfo = obj.readValue(user.getBody(), KaKaoUserInfo.class);
            System.out.println("kaUserInfo = " + kaUserInfo);
            System.out.println("KaKaoUserInfo.kakao_account = " + kaUserInfo.kakao_account.getEmail() + "," + kaUserInfo.properties.getNickname());
            LoginDto loginDto = new LoginDto(kaUserInfo.getId(), kaUserInfo.kakao_account.getEmail(), kaUserInfo.properties.getNickname(), SocialPath.KAKAO);
            return loginDto;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }



}
