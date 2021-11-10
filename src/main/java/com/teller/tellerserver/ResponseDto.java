package com.teller.tellerserver;

import lombok.Data;

@Data
public class ResponseDto {

    private String message;

    public ResponseDto(){

    }

    public ResponseDto(String message) {
        this.message = message;
    }
}
