package com.example.demo.config.security.tokens;

import com.example.demo.api.request.FormLoginDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 12:44
 */
public class PreAuthorizationToken extends UsernamePasswordAuthenticationToken {

    public PreAuthorizationToken(String username, String password){
        super(username,password);
    }

    public PreAuthorizationToken(FormLoginDto dto){
        this(dto.getUsername(),dto.getPassword());
    }

    public String getUsername(){
        return (String)super.getPrincipal();
    }

    public String getUserPassword(){
        return (String)super.getCredentials();
    }

}
