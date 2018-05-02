package com.example.demo.config.security;

import com.example.demo.config.jwt.tokens.JwtPostProcessingToken;
import com.example.demo.domain.member.Member;
import com.example.demo.domain.role.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 12:39
 */
public class MemberContext extends User{

    private Member member;

    public MemberContext(Member member, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.member = member;
    }

    public MemberContext(String name, String password, String roles){
        super(name,password,parseAuthorities(roles));
    }

    public static MemberContext getMemeberContext(Member member, List<Role> roles){
        return new MemberContext(member,member.getName(),member.getPassword(),parseAuthorities(roles));
    }

    private static List<SimpleGrantedAuthority> parseAuthorities(List<Role> roles) {
        return roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());
    }

    private static List<SimpleGrantedAuthority> parseAuthorities(String roles){
        String[] tmp = roles.split(",");
        return Arrays.asList(tmp).stream().map(role -> new SimpleGrantedAuthority(role.toString())).collect(Collectors.toList());
    }

    public Member getMember(){
        return this.member;
    }

}
