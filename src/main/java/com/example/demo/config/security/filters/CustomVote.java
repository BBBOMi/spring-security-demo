package com.example.demo.config.security.filters;

import com.example.demo.domain.role.RoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 2
 * Time: 오후 2:52
 */
@Slf4j
public class CustomVote implements AccessDecisionVoter {

    @Override
    public int vote(Authentication authentication, Object object, Collection attributes) {
        List<SecurityConfig> securityConfigs = (List<SecurityConfig>) attributes;
        List<GrantedAuthority> urlRole = AuthorityUtils.commaSeparatedStringToAuthorityList(securityConfigs.toString());

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<GrantedAuthority> userRole = new ArrayList(authorities);

        boolean access = false;
        for(int i=0; i<urlRole.size(); i++){
            for(int j=0; j<userRole.size(); j++){
                log.info(urlRole.get(i).toString());
                log.info(userRole.get(j).toString());
                if(urlRole.get(i).toString().equals(userRole.get(j).toString()))
                    access = true;
            }
        }

        return access ? ACCESS_GRANTED : ACCESS_ABSTAIN;

    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class clazz) {
        return true;
    }

}
