package com.example.demo.config.jwt.tokens;

import com.example.demo.config.security.MemberContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 5:15
 */
@Slf4j
public class JwtPostProcessingToken extends UsernamePasswordAuthenticationToken {

    public JwtPostProcessingToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public static JwtPostProcessingToken getJwtPostProcessingToken(MemberContext memberContext){
        return new JwtPostProcessingToken(memberContext.getMember().getName(),memberContext.getMember().getPassword(),memberContext.getAuthorities());
    }
}
