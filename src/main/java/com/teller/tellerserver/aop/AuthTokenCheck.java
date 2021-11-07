package com.teller.tellerserver.aop;


import com.teller.tellerserver.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class AuthTokenCheck {

    @Around("execution(* com.teller.tellerserver.controller.*.*(..))")
    public Object tokenCheck(ProceedingJoinPoint pjp) throws Throwable{
        HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String token = req.getHeader("token");
        if(token == null || token.equals("")){
            return ResponseDto.builder()
                              .message("로그인 하세요")
                              .build();
        }
        Object[] args = pjp.getArgs();
        Object proceed = pjp.proceed(args);
        return proceed;
    }
}
