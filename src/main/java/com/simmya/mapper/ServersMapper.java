package com.simmya.mapper;

import com.simmya.pojo.Servers;

public interface ServersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Servers record);

    int insertSelective(Servers record);

    Servers selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Servers record);

    int updateByPrimaryKey(Servers record);
}