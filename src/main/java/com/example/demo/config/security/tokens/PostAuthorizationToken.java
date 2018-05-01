package com.example.demo.config.security.tokens;

import com.example.demo.config.security.MemberContext;
import com.example.demo.domain.member.Member;
import com.example.demo.dto.RolesPrivileges;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 12:44
 */
public class PostAuthorizationToken extends UsernamePasswordAuthenticationToken {

    public PostAuthorizationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public static PostAuthorizationToken getTokenFromMemberContext(MemberContext memberContext) {
        return new PostAuthorizationToken(memberContext, memberContext.getPassword(), memberContext.getAuthorities());
    }

}
