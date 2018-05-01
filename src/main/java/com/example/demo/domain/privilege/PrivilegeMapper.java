package com.example.demo.domain.privilege;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 12:27
 */
@Mapper
public interface PrivilegeMapper {
    void save(Privilege privilege);
}
