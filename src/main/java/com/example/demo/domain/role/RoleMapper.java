package com.example.demo.domain.role;

import com.example.demo.domain.privilege.Privilege;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 12:28
 */
@Mapper
public interface RoleMapper {
    void save(Role role);
    void rolesPrivilegesSave(@Param("roleId") Long roleId, @Param("privilegeId") Long privilegeId);
}
