package com.example.demo.config.jwt.filters;

import com.example.demo.advice.JwtException;
import com.example.demo.config.jwt.handlers.JwtAuthenticationFailureHandler;
import com.example.demo.config.jwt.tokens.JwtPreProcessingToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 4:58
 */
@Slf4j
public class JwtFilter extends AbstractAuthenticationProcessingFilter {

    public static final String HEADER_PREFIX = "Bearer ";

    private JwtAuthenticationFailureHandler failureHandler;

    protected JwtFilter(RequestMatcher reuqestMatcher){
        super(reuqestMatcher);
    }

    public JwtFilter(RequestMatcher matcher, JwtAuthenticationFailureHandler jwtAuthenticationFailureHandler) {
        super(matcher);

        this.failureHandler = jwtAuthenticationFailureHandler;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String jwtToken = request.getHeader("Authorization");

        jwtToken = tokenHeaderValidation(jwtToken);

        JwtPreProcessingToken jwtPreProcessingToken = new JwtPreProcessingToken(jwtToken);

        return super.getAuthenticationManager().authenticate(jwtPreProcessingToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        context.setAuthentication(authResult);
        SecurityContextHolder.setContext(context);

        log.info(authResult.getName() + "님 로그인");

        chain.doFilter(request,response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        SecurityContextHolder.clearContext();

        this.unsuccessfulAuthentication(request,response,failed);
    }

    private String tokenHeaderValidation(String header){
        if(StringUtils.isEmpty(header) | header.length() < HEADER_PREFIX.length())
            throw new JwtException("토큰 헤더정보가 유효하지 않습니다.");


        return header.substring(HEADER_PREFIX.length(), header.length());
    }
}
