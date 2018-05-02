package com.example.demo.config.security.providers;

import com.example.demo.advice.LoginException;
import com.example.demo.config.security.MemberContext;
import com.example.demo.config.security.tokens.PostAuthorizationToken;
import com.example.demo.config.security.tokens.PreAuthorizationToken;
import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.MemberMapper;
import com.example.demo.domain.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 12:43
 */
@Component
public class FormLoginProvider implements AuthenticationProvider {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        PreAuthorizationToken preAuthorizationToken = (PreAuthorizationToken) authentication;

        Optional<String> username = Optional.ofNullable((String)preAuthorizationToken.getPrincipal());
        Optional<String> password = Optional.ofNullable((String)preAuthorizationToken.getCredentials());

        username.orElseThrow(() -> new LoginException("아이디를 입력하세요"));
        password.orElseThrow(() -> new LoginException("패스워드를 입력하세요."));

        Optional<Member> member = Optional.ofNullable(memberMapper.findByUsername(username.get()));
        member.orElseThrow(() -> new LoginException("존재하지 않는 사용자입니다."));

        List<Role> roles = memberMapper.findByUserIdAndRole(member.get().getId());
        if(passwordEncoder.matches(password.get(),member.get().getPassword())){
            return PostAuthorizationToken.getPostAuthorizationToken(MemberContext.getMemeberContext(member.get(),roles));
        }

        throw new LoginException("패스워드가 일치하지 않습니다.");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PreAuthorizationToken.class.isAssignableFrom(authentication);
    }
}
