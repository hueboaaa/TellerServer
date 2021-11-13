package com.teller.tellerserver.parse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teller.tellerserver.ResponseDto;
import com.teller.tellerserver.dto.Google.GoogleResponseDto;
import com.teller.tellerserver.dto.Google.GoogleUserInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class GoogleParse {

    public String google_login_connect(String code){
        RestTemplate rs = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "274415327987-cp6jv7c0q6o7kr2cv73sauimt7v60m6f.apps.googleusercontent.com");
        params.add("redirect_uri", "http://localhost:8083/googleLogin");
        params.add("client_secret", "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");
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, httpHeaders);

        ResponseEntity<String> response = rs.postForEntity("https://www.googleapis.com/oauth2/v4/token", request, String.class);
        System.out.println("response.getBody() = " + response.getBody());
        try{
            ObjectMapper obj = new ObjectMapper();
            GoogleResponseDto googleResponseDto = obj.readValue(response.getBody(), GoogleResponseDto.class);
            System.out.println("googleResponseDto.getAccess_token() = " + googleResponseDto.getAccess_token());
            return googleResponseDto.getId_token();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ResponseDto findGoogleUserInfo(String code){
        String Access_token = this.google_login_connect(code);

        String requestUrl = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo").queryParam("id_token", Access_token).toUriString();


//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization", "Bearer " +Access_token);

        RestTemplate rs = new RestTemplate();
        String forObject = rs.getForObject(requestUrl, String.class);
        ObjectMapper obj = new ObjectMapper();
        try{
            GoogleUserInfo googleUserInfo = obj.readValue(forObject, GoogleUserInfo.class);
            System.out.println("googleUserInfo = " + googleUserInfo);
            return googleUserInfo;
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDto("JSON 파싱 에러");
        }
        
//        ResponseEntity<String> response = rs.getForEntity("https://www.googleapis.com/auth/userinfo.email" + Access_token, String.class);
//        System.out.println("response = " + response.getBody());
    }
}
