package com.example.demo.config.security;

import com.example.demo.config.security.tokens.PostAuthorizationToken;
import com.example.demo.domain.member.Member;
import com.example.demo.dto.RolesPrivileges;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public static MemberContext formMemberModel(Member member, List<RolesPrivileges> rolesPrivileges){
        return new MemberContext(member,member.getName(),member.getPassword(),parseAuthorities(rolesPrivileges));
    }

    private static List<SimpleGrantedAuthority> parseAuthorities(List<RolesPrivileges> rolesPrivilegesList){
        Map<String,StringBuilder> map = new HashMap<>();
        for(int i=0; i<rolesPrivilegesList.size();i++){
            RolesPrivileges rolesPrivileges = rolesPrivilegesList.get(i);
            if(map.containsKey(rolesPrivileges.getRoleName())){
                map.put(rolesPrivileges.getRoleName(),map.get(rolesPrivileges.getRoleName()).append(", ").append(rolesPrivileges.getPrivilegeName()));
            }else{
                map.put(rolesPrivileges.getRoleName(),new StringBuilder().append(rolesPrivileges.getPrivilegeName()));
            }
        }

        return rolesPrivilegesList.stream().map(r -> new SimpleGrantedAuthority(r.getPrivilegeName())).collect(Collectors.toList());
    }

    public Member getMember(){
        return this.member;
    }

}
