package com.example.demo.domain.resource;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 10:03
 */
@Mapper
public interface ResourceMapper {
    void save(Resource resource);
    List<String> findAllResources();
}
