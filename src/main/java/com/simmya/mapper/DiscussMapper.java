package com.simmya.mapper;

import com.simmya.pojo.Discuss;

public interface DiscussMapper {
    int deleteByPrimaryKey(String id);

    int insert(Discuss record);

    int insertSelective(Discuss record);

    Discuss selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Discuss record);

    int updateByPrimaryKey(Discuss record);
}