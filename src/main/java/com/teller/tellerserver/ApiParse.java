package com.teller.tellerserver;

import org.springframework.data.querydsl.binding.MultiValueBinding;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class ApiParse {

    private static final String KAKAO_REQUEST_URL =
            "https://kauth.kakao.com/oauth/token";


    public static void kakao_login_connect(String code){

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

    }

}
