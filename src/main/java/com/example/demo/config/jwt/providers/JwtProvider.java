package com.example.demo.config.jwt.providers;

import com.example.demo.config.jwt.JwtDecoder;
import com.example.demo.config.jwt.tokens.JwtPostProcessingToken;
import com.example.demo.config.jwt.tokens.JwtPreProcessingToken;
import com.example.demo.config.security.MemberContext;
import com.example.demo.config.security.tokens.PostAuthorizationToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 5:21
 */
@Component
@Slf4j
public class JwtProvider implements AuthenticationProvider {

    @Autowired
    private JwtDecoder jwtDecoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String token = (String)authentication.getPrincipal();

        MemberContext memberContext = jwtDecoder.decodeJwt(token);

        return PostAuthorizationToken.getPostAuthorizationToken(memberContext);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtPreProcessingToken.class.isAssignableFrom(authentication);
    }
}
