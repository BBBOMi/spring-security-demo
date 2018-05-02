package com.example.demo.config.security.handlers;

import com.example.demo.api.response.FormLoginResponseDto;
import com.example.demo.config.jwt.JwtFactory;
import com.example.demo.config.security.MemberContext;
import com.example.demo.config.security.tokens.PostAuthorizationToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 12:42
 */
@Component
public class FormLoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JwtFactory factory;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        PostAuthorizationToken token = (PostAuthorizationToken)authentication;

        MemberContext memberContext = (MemberContext) token.getPrincipal();

        String tokenString = factory.generateToken(memberContext);

        FormLoginResponseDto formLoginResponseDto = new FormLoginResponseDto(tokenString);

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write(objectMapper.writeValueAsString(formLoginResponseDto));

    }

}