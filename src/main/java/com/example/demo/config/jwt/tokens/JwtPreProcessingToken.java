package com.example.demo.config.jwt.tokens;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 5:13
 */
public class JwtPreProcessingToken extends UsernamePasswordAuthenticationToken {

    private JwtPreProcessingToken(Object principal, Object credentials){
        super(principal,credentials);
    }

    public JwtPreProcessingToken(String token){
        this(token,null);
    }
}
