package com.example.demo.config.security.tokens;

import com.example.demo.config.security.MemberContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 12:44
 */
public class PostAuthorizationToken extends UsernamePasswordAuthenticationToken {

    private PostAuthorizationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public PostAuthorizationToken(PreAuthorizationToken preAuthorizationToken){
        this(preAuthorizationToken.getPrincipal(),preAuthorizationToken.getCredentials(),null);
    }

    public static PostAuthorizationToken getPostAuthorizationToken(MemberContext memberContext){
        return new PostAuthorizationToken(memberContext,memberContext.getPassword(),memberContext.getAuthorities());
    }
}
