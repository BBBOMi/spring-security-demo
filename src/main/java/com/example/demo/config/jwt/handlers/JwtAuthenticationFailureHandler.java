package com.example.demo.config.jwt.handlers;

import com.example.demo.advice.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 5:01
 */
@Component
@Slf4j
public class JwtAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        log.error(exception.getMessage());

        throw new JwtException(exception.getMessage());
    }
}
