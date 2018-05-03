package com.example.demo.config.security.filters;

import com.example.demo.advice.BadRequestException;
import com.example.demo.domain.member.Member;
import com.example.demo.domain.resource.Resource;
import com.example.demo.domain.resource.ResourceMapper;
import com.example.demo.domain.role.Role;
import com.example.demo.domain.role.RoleMapper;
import com.example.demo.dto.RoleByUrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.security.Principal;
import java.util.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 2
 * Time: 오후 2:13
 */
@Slf4j
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private RoleMapper roleMapper;

    public CustomFilterInvocationSecurityMetadataSource(RoleMapper roleMapper){
        super();
        this.roleMapper = roleMapper;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        FilterInvocation filterInvocation = (FilterInvocation)object;
        String url = filterInvocation.getRequestUrl();

        if(url.indexOf("?")!=-1){
            url = url.substring(0,url.indexOf("?"));
        }

        List<String> resources = roleMapper.findByRoleAndResource(url);
        List<ConfigAttribute> attributes = new ArrayList<>();

        attributes.addAll(SecurityConfig.createList(resources.toArray(new String[resources.size()])));

        return attributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
