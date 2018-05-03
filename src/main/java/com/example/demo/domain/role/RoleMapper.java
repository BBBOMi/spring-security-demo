package com.example.demo.domain.role;

import com.example.demo.dto.RoleByUrl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 12:28
 */
@Mapper
public interface RoleMapper {
    void save(Role role);
    void rolesResourcesSave(@Param("resouceId") Long resourceId, @Param("roleId") Long roleId);
    List<String> findByRoleAndResource(String url);
}
