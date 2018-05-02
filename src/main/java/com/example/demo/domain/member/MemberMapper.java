package com.example.demo.domain.member;

import com.example.demo.domain.role.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 12:27
 */
@Mapper
public interface MemberMapper {
    Member findByUsername(String username);
    void save(Member member);
    void membersRolesSave(@Param("memberId") Long memberId, @Param("roleId") Long roleId);
    List<Role> findByUserIdAndRole(Long memberId);
}
